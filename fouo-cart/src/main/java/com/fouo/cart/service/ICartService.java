package com.fouo.cart.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fouo.cart.entity.Cart;
import com.fouo.cart.entity.CartItem;
import com.google.gson.Gson;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface ICartService extends IService<Cart> {
    /**
     * 添加商品到购物车
     * @param skuId
     * @param num
     * @return
     */
    CartItem addToCart(Long skuId, Integer num) throws ExecutionException, InterruptedException;

    /**
     * 获取整个购物车对象
     * @return
     */
    Cart getCart() throws ExecutionException, InterruptedException;

    /**
     * 清空购物车
     * @param cartKey
     */
    public void clearCart(String cartKey);

    /**
     * 获取当前用户购车中的购物项列表
     * @return
     */
    List<CartItem> getCurrentUserCartItems();
}
