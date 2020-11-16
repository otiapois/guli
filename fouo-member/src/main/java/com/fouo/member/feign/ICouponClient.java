package com.fouo.member.feign;

import com.fouo.common.constant.CommonConstant;
import com.fouo.common.support.R;
import com.fouo.coupon.entity.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 优惠券服务
 * Feign接口类
 *
 * 本质是在自己服务内写一个接口 在接口中写一个与需要调用服务的controller适配的方法
 * 然后在自己服务内调用这个方法
 *
 *  这里CommonConstant.APPLICATION_COUPON_NAME 是先去注册中心 找到该服务（fouo-coupon）
 *  然后再找该服务下的/coupon/feign 接口 进行适配
 * @author fouo
 * @date 2020/6/4 17:03
 */
@FeignClient(value = CommonConstant.APPLICATION_COUPON_NAME, fallback = ICouponClientFallback.class)
public interface ICouponClient {
//
//    String API_PREFIX = "/coupon";
//    String FEIGN = API_PREFIX + "/feign";
//
//    @RequestMapping(value = FEIGN,method = RequestMethod.GET)
//    public R<Coupon> testFeign();
}
