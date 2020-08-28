package com.fouo.oauth2.feign;

import com.fouo.common.support.R;

/**
 * 第三方服务远程调用接口异常回执
 *
 * @author fouo
 * @date 2020/8/20 9:05
 */
public class IThirdPartFallback implements IThirdPartClinet{

    @Override
    public R sendCode(String phone, String code) {
        return R.fail("验证码发送失败，请验证后重新发送！");
    }
}
