package com.fouo.oauth2.controller;

import com.fouo.common.support.R;
import com.fouo.common.vo.MemberSocialVO;
import com.fouo.oauth2.constant.AuthServerConstant;
import com.fouo.oauth2.feign.IMemberClinet;
import com.fouo.oauth2.vo.SocialUserVO;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

/**
 * 处理社交登录请求
 *
 * @author fouo
 * @date 2020/8/24 10:41
 */
@Slf4j
@Controller
@RequestMapping("/oauth2/oauth2.0")
public class OAuth2Controller {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private IMemberClinet iMemberClinet;

    /**
     * 用户授权成功后第三方服务返回一个code 用于code想三方服务的认证服务器兑换token
     *
     * @param code
     * @return
     */
    @GetMapping("/weibo/success")
    public String weibo(@RequestParam("code") String code, HttpSession session) {

        Gson gson = new Gson();
        /**
         * 使用map进行传参
         */
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("client_id", "4017199270");
        parameters.add("client_secret", "1119736f01f3c5acb76c6eb73063d309");
        parameters.add("grant_type", "authorization_code");
        parameters.add("redirect_uri", "http://fouomall.com/api/oauth2/oauth2.0/weibo/success");
        parameters.add("code", code);

        String json = restTemplate.postForObject("https://api.weibo.com/oauth2/access_token", parameters, String.class);

        if (StringUtils.isNotBlank(json)) {
            //获取包含token的json串，以VO的方式进行返回
            SocialUserVO socialUserVO = gson.fromJson(json, SocialUserVO.class);
            //知道当前是哪个社交用户
            // 当前用户如果是第一次进网站，自动注册进来
            // （为当前社交用户生成一个会员信息账号，以后这个账号就对应指定的会员）
            //登录或者注册该社交用户
            R<MemberSocialVO> result = iMemberClinet.socialLogin(socialUserVO);

            if (result.getCode() == 200) {
                log.info(result.getData().toString());
                session.setAttribute(AuthServerConstant.LOGIN_USER, result.getData());
                //登录成功 跳转回首页
                return "redirect:http://fouomall.com";
            } else {
                //登录失败
                return "redirect:http://oauth2.fouomall.com/login.html";
            }
        } else {
            //登录失败
            return "redirect:http://oauth2.fouomall.com/login.html";
        }

    }
}