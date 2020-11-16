package com.fouo.oauth2.feign;

import com.fouo.common.support.R;
import com.fouo.oauth2.vo.MemberRegistVO;
import com.fouo.oauth2.vo.SocialUserVO;
import com.fouo.oauth2.vo.UserLoginVO;

/**
 * 会员服务远程调用接口异常回执
 *
 * @author fouo
 * @date 2020/8/20 9:05
 */
public class IMemberFallback implements IMemberClinet{
    @Override
    public R regist(MemberRegistVO memberRegistVO) {
        return R.fail("注册调用失败");
    }

    @Override
    public R login(UserLoginVO userLoginVO) {
        return R.fail("用户命或密码失败,请核对后重新登录！");
    }

    @Override
    public R socialLogin(SocialUserVO socialUserVO) {
        return R.fail("第三方服务登录失败");
    }
}
