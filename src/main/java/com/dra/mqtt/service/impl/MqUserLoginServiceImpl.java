package com.dra.mqtt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.dra.mqtt.entity.MqUser;
import com.dra.mqtt.mapper.MqUserMapper;
import com.dra.mqtt.service.MqUserLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.text.html.parser.Entity;
import java.util.concurrent.locks.Condition;

/**
 * <p>
 * 用户登录业务类
 * </p>
 *
 * @author: dra
 * @since: 2022/5/23
 */
@Service
public class MqUserLoginServiceImpl implements MqUserLoginService {

    @Resource
    private MqUserMapper mqUserMapper;

    @Override
    public MqUser login(String username, String password) {
        //获取用户数据
        LambdaQueryWrapper<MqUser> mqUserLambdaQueryWrapper = new LambdaQueryWrapper<MqUser>();
        mqUserLambdaQueryWrapper.eq(MqUser::getUsername,username);
        MqUser username1 = mqUserMapper.selectOne(mqUserLambdaQueryWrapper);
        if (null!=username1&&password.equals(username1.getPassword())){
            return username1;
        }
        return null;
    }
}
