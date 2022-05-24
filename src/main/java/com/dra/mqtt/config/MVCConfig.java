package com.dra.mqtt.config;

import com.dra.mqtt.handler.MqUserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * <p>
 * web配置
 * </p>
 *
 * @author: dra
 * @since: 2022/5/23
 */
@Configuration
public class MVCConfig implements WebMvcConfigurer {

    @Resource
    private MqUserInterceptor mqUserInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mqUserInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/login/**")
                .excludePathPatterns("/loginPage")
                .excludePathPatterns("/");
//                .excludePathPatterns("/mqtt");
//                .excludePathPatterns("/loginPage.html");
    }
}
