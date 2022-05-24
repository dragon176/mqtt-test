package com.dra.mqtt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 页面前端控制器
 * </p>
 *
 * @author: dra
 * @since: 2022/5/23
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String loginPageRoot(){
        return "login";
    }

    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/mqtt")
    public String mqtt(){
        return "mqtt";
    }


}
