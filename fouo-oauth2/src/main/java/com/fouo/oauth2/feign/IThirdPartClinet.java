package com.fouo.oauth2.feign;

import com.fouo.common.constant.CommonConstant;
import com.fouo.common.support.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 第三方服务远程调用接口
 *
 * @author fouo
 * @date 2020/8/20 9:05
 */
@FeignClient(value = CommonConstant.APPLICATION_THIRDPARTY_NAME, fallback = IThirdPartFallback.class)
public interface IThirdPartClinet {
    @GetMapping("/third/sms/sendcode")
    public R sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code);
}
