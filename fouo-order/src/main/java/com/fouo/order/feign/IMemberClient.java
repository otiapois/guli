package com.fouo.order.feign;

import com.fouo.common.constant.CommonConstant;
import com.fouo.order.vo.MemberReceiveAddressVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 商品远程调用接口
 *
 * @author fouo
 * @date 2020/9/1 16:34
 */
@FeignClient(value = CommonConstant.APPLICATION_PRODUCT_NAME, fallback = IMemberClientFallback.class)
public interface IMemberClient {

    @GetMapping("/member/memberreceiveaddress/{memberId}/address")
    public List<MemberReceiveAddressVO> getAddress(@PathVariable("memberId") Long memberId);
}