package com.dra.mqtt.controller;

import com.alibaba.fastjson.JSON;
import com.dra.mqtt.entity.MqUser;
import com.dra.mqtt.service.MqUserLoginService;
import com.dra.mqtt.utils.ControllerFinalSet;
import com.dra.mqtt.utils.RestTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * <p>
 * 用户登录前端控制器
 * </p>
 *
 * @author: dra
 * @since: 2022/5/23
 */
@RestController
@RequestMapping("/login")
public class MqUserLoginController {

    @Resource
    private MqUserLoginService mqUserLoginService;

    @PostMapping
    public RestTemplate<?> login(@RequestBody String user, HttpSession session, HttpServletResponse response){
        System.out.println(user);
        Map<String,Map<String,String>> map = (Map<String,Map<String,String>>) JSON.parse(user);
        System.out.println(map);
        String username = map.get("user").get("username");
        String password = map.get("user").get("password");
        System.out.println(username+":"+password);
        //验证用户账号密码
        MqUser login = mqUserLoginService.login(username, password);
        if(null!=login){
            session.setAttribute("username",login.getUsername());

            return new RestTemplate<>("/mqtt", ControllerFinalSet.SUCCESS_CODE,ControllerFinalSet.LOGIN_SUCCESS_MES);
        }
        return new RestTemplate<>(false, ControllerFinalSet.FAIL_CODE,ControllerFinalSet.LOGIN_FAIL_MES);
    }
}
