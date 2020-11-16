package com.fouo.cart.interceptor;

import com.fouo.cart.constant.AuthServerConstant;
import com.fouo.cart.constant.CartConstant;
import com.fouo.cart.vo.UserInfoVO;
import com.fouo.common.vo.MemberSocialVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * 购物车拦截器
 * 在执行目标方法之前来判断 用户的登录状态
 * 并封装和传递给controller目标请求
 *
 * @author fouo
 * @date 2020/9/1 10:09
 */
public class CartInterceptor implements HandlerInterceptor {

    public static ThreadLocal<UserInfoVO> threadLocal = new ThreadLocal<>();

    /**
     * 在目标方法执行之前生效
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserInfoVO userInfoVO = new UserInfoVO();

        HttpSession session = request.getSession();

        MemberSocialVO member = (MemberSocialVO) session.getAttribute(AuthServerConstant.LOGIN_USER);

        if (member != null) {
            //用户已登录
            userInfoVO.setUserId(member.getId());
        }

        //用户未登录
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(CartConstant.TEMP_USER_COOKIE_NAME)) {
                    userInfoVO.setUserKey(cookie.getValue());
                    //标识为临时用户
                    userInfoVO.setTempUser(true);
                }
            }
        }

        //第一次使用 且没有登录
        if (StringUtils.isBlank(userInfoVO.getUserKey())) {
            userInfoVO.setUserKey(UUID.randomUUID().toString());
        }
        //目标方法执行之前
        threadLocal.set(userInfoVO);
        return true;
    }

    /**
     * 在业务执行之后
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        UserInfoVO userInfoVO = threadLocal.get();
        if (!userInfoVO.getTempUser()) {
            Cookie cookie = new Cookie(CartConstant.TEMP_USER_COOKIE_NAME, userInfoVO.getUserKey());
            //设置cookie的作用域
            cookie.setDomain("fouomall.com");
            //设置cookie的过期时间
            cookie.setMaxAge(CartConstant.TEMP_USER_COOKIE_TIMEOUT);
            response.addCookie(cookie);
        }
    }
}
