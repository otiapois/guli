package com.fouo.oauth2.feign;

import com.fouo.common.constant.CommonConstant;
import com.fouo.common.support.R;
import com.fouo.common.vo.MemberSocialVO;
import com.fouo.oauth2.vo.MemberRegistVO;
import com.fouo.oauth2.vo.SocialUserVO;
import com.fouo.oauth2.vo.UserLoginVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 会员模块远程接口
 *
 * @author fouo
 * @date 2020/8/20 9:05
 */
@FeignClient(value = CommonConstant.APPLICATION_MEMBER_NAME, fallback = IMemberFallback.class)
public interface IMemberClinet {
    @PostMapping("/member/member/regist")
    public R regist(@RequestBody MemberRegistVO memberRegistVO);

    @PostMapping("/member/member/login")
    public R<MemberSocialVO> login(@RequestBody UserLoginVO userLoginVO);

    @PostMapping("/member/member/oauth2/login")
    public R<MemberSocialVO> socialLogin(@RequestBody SocialUserVO socialUserVO);
}
