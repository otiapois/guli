package com.fouo.product.web;

import com.fouo.product.entity.Category;
import com.fouo.product.service.ISkuInfoService;
import com.fouo.product.vo.ext.SkuItemVO;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 商品详情页面
 *
 * @author fouo
 * @date 2020/8/13 17:23
 */
@Controller
@AllArgsConstructor
@Api(value = "详情页", tags = "详情页接口")
public class ItemController {

    @Autowired
    private ISkuInfoService iSkuInfoService;

    /**
     * 展示当前sku的详情
     *
     * @return
     */
    @GetMapping({"/{skuId}.html"})
    public String indexPage(@PathVariable("skuId") Long skuId,Model model) {
        SkuItemVO itemVO = iSkuInfoService.item(skuId);
        model.addAttribute("item",itemVO);
        return "item";
    }
}
