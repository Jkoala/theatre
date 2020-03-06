package com.devin.config;

import com.devin.web.interceptor.LocaleInterceptor;
import com.devin.web.interceptor.LoginInterceptor;
import org.apache.catalina.filters.RequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * User: devin
 * Date: 2020/2/19
 * Time: 19:27
 * Description: No Description
 */

@SpringBootConfiguration
public class SpringMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LocaleInterceptor localeInterceptor;

    @Autowired
    private LoginInterceptor loginInterceptor;
    /**
     * 注册拦截器
     *
     * @param registry registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/user.*")
                .addPathPatterns("/user/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/getLogin")
                .excludePathPatterns("/static/**");

        registry.addInterceptor(localeInterceptor)
                .addPathPatterns("/user.*")
                .addPathPatterns("/user/**")
                .addPathPatterns("/install");
        registry.addInterceptor(localeChangeInterceptor())
                .addPathPatterns("/install");
    }

    /**
     * 配置静态资源路径
     *
     * @param registry registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/**");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
}


    /**
     * 国际化设置
     *
     * @return LocaleResolver
     */
    @Bean
    public LocaleResolver localeResolver() {
        final SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.CHINA);
        return slr;
    }

    /**
     * 国际化参数拦截器
     *
     * @return LocaleChangeInterceptor
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        final LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }



}
