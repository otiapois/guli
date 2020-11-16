package com.fouo.oauth2.web;

import com.fouo.common.vo.MemberSocialVO;
import com.fouo.oauth2.constant.AuthServerConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * 登录/注册 跳转页面controller
 *
 * @author fouo
 * @date 2020/8/17 16:00
 */
@Slf4j
@Controller
public class Oauth2Controller {
//    /**
//     * Springmvc的 viewController 方法
//     * @return
//     */
//    @GetMapping("/login.html")
//    public String loginPage() {
//        return "login";
//    }
//    @GetMapping("/reg.html")
//    public String regPage() {
//        return "reg";
//    }

    @GetMapping("/login.html")
    public String loginPage(HttpSession session) {
        MemberSocialVO member = (MemberSocialVO) session.getAttribute(AuthServerConstant.LOGIN_USER);
        if (member == null) {

            //当前没有用户登录
            return "login";
        } else {
            log.info(member.toString());
            return "redirect:http://fouomall.com";
        }

    }
}
