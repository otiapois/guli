package com.fouo.order.interceptor;

import com.fouo.common.vo.MemberSocialVO;
import com.fouo.order.constant.AuthServerConstant;
import com.fouo.order.constant.OrderConstant;
import com.fouo.order.vo.UserInfoVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author fouo
 * @date 2020/9/11 10:36
 */
@Component
public class LoginUserInterceptor implements HandlerInterceptor {
    public static ThreadLocal<MemberSocialVO> threadLocal = new ThreadLocal<>();

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

        MemberSocialVO member = (MemberSocialVO) request.getSession().getAttribute(AuthServerConstant.LOGIN_USER);
        if (member != null) {
            threadLocal.set(member);
            //用户已登录,放行
            return true;
        } else {
            request.getSession().setAttribute("msg", "请先登录");
            //重定向到登录页面
            response.sendRedirect("http://oauth2.fouomall.com/login.html");
            //拦截请求
            return false;
        }
    }
}
