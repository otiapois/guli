package com.fouo.order.web;

import com.fouo.order.feign.IMemberClient;
import com.fouo.order.service.IOrderService;
import com.fouo.order.vo.OrderConfirmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 订单跳转controller
 *
 * @author fouo
 * @date 2020/9/11 9:39
 */
@Controller
public class OrderWebController {

    @Autowired
    private IOrderService orderService;
    @GetMapping("/toTrade")
    public String toTrade(Model model) {
        OrderConfirmVO confirmVO =  orderService.confirmOrder();
        model.addAttribute("orderConfirmData",confirmVO);
        return "confirm";
    }
}
