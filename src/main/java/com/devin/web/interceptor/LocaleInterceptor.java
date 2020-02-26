package com.devin.web.interceptor;


import cn.hutool.core.util.StrUtil;
import com.devin.model.dto.TheatrePropertiesEnum;
import com.devin.model.enums.LocaleEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

import static com.devin.model.dto.TheatreConst.OPTIONS;

/**
 * @author : devin
 * @version : 1.0
 * @date : 2020/2/20
 */
@Component
public class LocaleInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final Object attribute = request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        //如果属性不等于空
        if (null != attribute) {
            return true;
        }
        //等于空重新设置属性
        if (StrUtil.equals(LocaleEnum.EN_US.getValue(), OPTIONS.get(TheatrePropertiesEnum.THEATRE_LOCALE.getProp()))) {
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("en", "US"));
        } else {
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("zh", "CN"));
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
