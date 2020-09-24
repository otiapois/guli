package com.fouo.cart.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fouo.cart.constant.CartConstant;
import com.fouo.cart.entity.Cart;
import com.fouo.cart.entity.CartItem;
import com.fouo.cart.feign.IProductClient;
import com.fouo.cart.interceptor.CartInterceptor;
import com.fouo.cart.mapper.CartMapper;
import com.fouo.cart.service.ICartService;
import com.fouo.cart.vo.SkuInfoVO;
import com.fouo.cart.vo.UserInfoVO;
import com.fouo.common.support.R;
import com.google.gson.Gson;
import jdk.nashorn.internal.ir.CatchNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private IProductClient productClient;
    @Autowired
    private ThreadPoolExecutor executor;

    @Override
    public CartItem addToCart(Long skuId, Integer num) throws ExecutionException, InterruptedException {
        Gson gson = new Gson();
        CartItem cartItem = new CartItem();
        BoundHashOperations<String, Object, Object> cartOptions = getCartOptions();
        Object o = cartOptions.get(skuId.toString());
        if (o == null) {
            //购物车没有此商品
            //添加新商品进购物车
            //异步编排(使用多线程的方式进行) 第一个异步任务
            CompletableFuture<Void> getSkuInfoTask = CompletableFuture.runAsync(() -> {
                //根据skuId查询当前要添加的商品详情信息
                SkuInfoVO skuInfo = productClient.getSkuBySkuId(skuId).getData();
                cartItem.setImage(skuInfo.getSkuDefaultImg());
                cartItem.setCheck(true);
                cartItem.setCount(num);
                cartItem.setTitle(skuInfo.getSkuTitle());
                cartItem.setSkuId(skuId);
                cartItem.setPrice(skuInfo.getPrice());
            }, executor);

            //获取销售属性
            CompletableFuture<Void> getSkuSaleAttrTask = CompletableFuture.runAsync(() -> {
                //远程查询sku的组合信息 第二个异步任务
                List<String> values = productClient.getSkuSaleAttrValues(skuId);
                cartItem.setSkuAttr(values);
            }, executor);

            CompletableFuture.allOf(getSkuInfoTask, getSkuSaleAttrTask).get();
            cartOptions.put(skuId.toString(), gson.toJson(cartItem));
            return cartItem;
        } else {
            //购物车原先有该商品
            CartItem oldCartItem = gson.fromJson(o.toString(), CartItem.class);
            Integer count = oldCartItem.getCount();
            oldCartItem.setCount(count + num);
            cartOptions.put(skuId.toString(), gson.toJson(oldCartItem));
            return oldCartItem;
        }

    }

    @Override
    public Cart getCart() throws ExecutionException, InterruptedException {
        Gson gson = new Gson();

        //首先要判断购物车的状态（用户是否登录）
        UserInfoVO userInfoVO = CartInterceptor.threadLocal.get();
        Cart cart = new Cart();

        if (userInfoVO.getUserId() != null) {
            //用户已经登录
            String cartKey = CartConstant.CART_PREFIX + userInfoVO.getUserId();
            BoundHashOperations<String, Object, Object> operations = redisTemplate.boundHashOps(cartKey);

            //如果临时购物车的数据还没有合并，则合并
            //先获取临时购物车中的
            String tempCartKey = CartConstant.CART_PREFIX + userInfoVO.getUserKey();
            List<CartItem> tempCartItems = getCartItems(gson, tempCartKey);
            if (tempCartItems != null && tempCartItems.size() > 0) {
                //临时购物车中有数据,需要合并
                for (CartItem item : tempCartItems) {
                    addToCart(item.getSkuId(), item.getCount());
                }
                //清除临时购物车的数据
                clearCart(tempCartKey);
            }


            //获取登录后的购物车的数据
            List<CartItem> cartItems = getCartItems(gson, cartKey);
            cart.setItems(cartItems);

        } else {
            //用户未登录
            String cartKey = CartConstant.CART_PREFIX + userInfoVO.getUserKey();
            //获取临时购车的所有购物项目
            List<CartItem> cartItems = getCartItems(gson, cartKey);
            cart.setItems(cartItems);
        }
        return cart;
    }

    /**
     * 获取对购物车的操作
     *
     * @return
     */
    private BoundHashOperations<String, Object, Object> getCartOptions() {
        //获取用户信息
        UserInfoVO userInfoVO = CartInterceptor.threadLocal.get();
        String cartKey = "";
        if (userInfoVO.getUserId() != null) {
            //用户登录
            cartKey = CartConstant.CART_PREFIX + userInfoVO.getUserId();
        } else {
            //用户未登录
            cartKey = CartConstant.CART_PREFIX + userInfoVO.getUserKey();
        }
        BoundHashOperations<String, Object, Object> operations = redisTemplate.boundHashOps(cartKey);
        return operations;
    }


    /**
     * 获取相应购物车中的数据
     *
     * @param cartKey
     * @return
     */
    private List<CartItem> getCartItems(Gson gson, String cartKey) {
        BoundHashOperations<String, Object, Object> operations = redisTemplate.boundHashOps(cartKey);
        List<Object> values = operations.values();
        if (values != null && values.size() > 0) {
            List<CartItem> list = values.stream().map((obj) -> {
                String s = obj.toString();
                CartItem cartItem = gson.fromJson(s, CartItem.class);
                return cartItem;
            }).collect(Collectors.toList());
            return list;
        }
        return null;
    }

    @Override
    public void clearCart(String cartKey) {
        redisTemplate.delete(cartKey);
    }

    @Override
    public List<CartItem> getCurrentUserCartItems() {
        UserInfoVO userInfoVO = CartInterceptor.threadLocal.get();
        Gson gson = new Gson();
        if(userInfoVO == null){
            return null;
        }else{
            List<CartItem> cartItems = getCartItems(gson, CartConstant.CART_PREFIX + userInfoVO.getUserId());
//            List<CartItem> collect = cartItems.stream().filter(item -> {
//                return item.getCheck();
//            }).collect(Collectors.toList());
            return cartItems;
        }
    }
}