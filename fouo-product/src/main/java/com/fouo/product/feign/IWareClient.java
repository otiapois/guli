package com.fouo.product.feign;

import com.fouo.common.constant.CommonConstant;
import com.fouo.common.support.R;
import com.fouo.common.to.SkuReductionTO;
import com.fouo.product.vo.ext.Bounds;
import com.fouo.product.vo.ext.SkuHasStockV0;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 优惠券服务
 * Feign接口类
 *
 * 本质是在自己服务内写一个接口 在接口中写一个与需要调用服务的controller适配的方法
 * 然后在自己服务内调用这个方法
 *
 *  这里CommonConstant.APPLICATION_COUPON_NAME 是先去注册中心 找到该服务（fouo-ware）
 *  然后再找该服务下的/ware/feign 接口 进行适配
 * @author fouo
 * @date 2020/6/4 17:03
 */
@FeignClient(value = CommonConstant.APPLICATION_WARE_NAME, fallback = IWareFallback.class)
public interface IWareClient {

    @PostMapping("/ware/waresku/hasstock")
    public R<List<SkuHasStockV0>> getSkusHasStock(@RequestBody List<Long> skuIds);

}