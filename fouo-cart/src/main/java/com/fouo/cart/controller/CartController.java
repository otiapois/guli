package com.fouo.cart.controller;

import com.fouo.cart.entity.Cart;
import com.fouo.cart.entity.CartItem;
import com.fouo.cart.interceptor.CartInterceptor;
import com.fouo.cart.service.ICartService;
import com.fouo.cart.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.concurrent.ExecutionException;


/**
 * 购物车页面跳转控制器
 *
 * @author fouo
 * @date 2020/8/28 16:22
 */
@Slf4j
@Controller
public class CartController {

    @Autowired
    private ICartService iCartService;

    /**
     * 获取当前用户所有的购物项
     * @return
     */
    @GetMapping("/currentUserCartItems")
    public List<CartItem>  getCurrentUserCartItems(){

        return iCartService.getCurrentUserCartItems();
    }
    /**
     * 购物车跳转页
     *
     * @return
     */
    @GetMapping("/cartList.html")
    public String cartListPage(Model model) throws ExecutionException, InterruptedException {
        //获取购物车
        Cart cart = iCartService.getCart();

        model.addAttribute("cart", cart);

        return "cartList";
    }

    /**
     * 添加商品到购物车
     *
     * @return
     */
    @GetMapping("/addToCart")
    public String addToCart(@RequestParam("skuId") Long skuId,
                            @RequestParam("num") Integer num,
                            Model model) throws ExecutionException, InterruptedException {
        CartItem cartItem = iCartService.addToCart(skuId, num);
        model.addAttribute("item", cartItem);
        return "success";
    }
}
