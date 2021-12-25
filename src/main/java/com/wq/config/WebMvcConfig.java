package com.wq.config;

import com.wq.handle.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 邓卫平
 * @date 2021/12/18 11:19
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录操作不拦截
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/sys/login")
                .excludePathPatterns("/sys/register")
                .excludePathPatterns("/swagger-ui.html/**")
                .excludePathPatterns("/v2/**")
                .excludePathPatterns("/webjars/**")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/csrf/**");
    }
}

