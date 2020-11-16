package com.fouo.order.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 订单服务静态页面
 *
 * @author fouo
 * @date 2020/9/10 10:55
 */
@Controller
public class PageController {
    @GetMapping("/{page}.html")
    public String listPage(@PathVariable("page") String page) {
        return page;
    }
}
