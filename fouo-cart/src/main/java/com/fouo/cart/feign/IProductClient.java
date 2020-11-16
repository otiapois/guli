package com.fouo.cart.feign;

import com.fouo.cart.vo.SkuInfoVO;
import com.fouo.common.constant.CommonConstant;
import com.fouo.common.support.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 商品远程调用接口
 *
 * @author fouo
 * @date 2020/9/1 16:34
 */
@FeignClient(value = CommonConstant.APPLICATION_PRODUCT_NAME, fallback = IProductClientFallback.class)
public interface IProductClient {

    @GetMapping("/product/skuinfo/detail")
    public R<SkuInfoVO> getSkuBySkuId(@RequestParam("skuId") Long skuId);

    @GetMapping("/product/productattrvalue/stringlist/{skuId}")
    public List<String> getSkuSaleAttrValues(@PathVariable("skuId") Long skuId);
}