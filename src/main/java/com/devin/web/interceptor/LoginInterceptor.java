package com.devin.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.devin.model.dto.TheatreConst.USER_SESSION_KEY;

/**
 * <pre>
 *     后台登录控制器
 * </pre>
 *
 * @author : RYAN0UP
 * @date : 2017/12/13
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final Object obj = request.getSession().getAttribute(USER_SESSION_KEY);
        //如果user不为空则放行
        log.info("进入登入拦截器");
        if (null != obj) {
            log.info("拦截器返回true");
            return true;
        }
        //否则拦截并跳转到登录
        log.info("拦截器返回false");
        response.sendRedirect("/user/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
