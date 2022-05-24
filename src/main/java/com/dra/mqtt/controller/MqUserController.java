package com.dra.mqtt.controller;

import com.dra.mqtt.entity.MqUser;
import com.dra.mqtt.service.IMqUserService;
import com.dra.mqtt.utils.RestTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.awt.print.Book;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author dra
 * @since 2022-05-22
 */
@RestController
@RequestMapping("/mqUser")
public class MqUserController extends BaseController<MqUser>{
    @Resource
    private IMqUserService varService;
    private void isIService(){
        if (super.getIService()==null){
            super.setIService(varService);
        }
    }
    @PostMapping
    public RestTemplate<?> add(@RequestBody MqUser var) {
        isIService();
        return super.baseAdd(var);
    }
    @PutMapping
    public RestTemplate<?> update(@RequestBody MqUser var) {
        isIService();
        return super.baseUpdate(var);
    }
    @DeleteMapping("/{id}")
    public RestTemplate<?> del(@PathVariable Long id) {
        isIService();
        return super.baseDel(id);
    }
    @GetMapping
    public RestTemplate<?> select(@RequestParam(required = false, defaultValue = "-1") Long id,
                                       @RequestParam(required = false, defaultValue = "-1") Long pageSize,
                                       @RequestParam(required = false, defaultValue = "-1") Long pageNum) {
        isIService();
        return super.baseSelect(id, pageSize, pageNum);
    }
}
