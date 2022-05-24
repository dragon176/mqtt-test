package com.dra.mqtt.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * 用户登录拦截拦截器
 * </p>
 *
 * @author: dra
 * @since: 2022/5/23
 */
@Component
public class MqUserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取Session中的信息
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (null==username||"".equals(username.trim())){
            response.sendRedirect("/");
            return false;
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
