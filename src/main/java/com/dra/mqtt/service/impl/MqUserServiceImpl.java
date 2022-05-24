package com.dra.mqtt.service.impl;

import com.dra.mqtt.entity.MqUser;
import com.dra.mqtt.mapper.MqUserMapper;
import com.dra.mqtt.service.IMqUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author dra
 * @since 2022-05-22
 */
@Service
public class MqUserServiceImpl extends ServiceImpl<MqUserMapper, MqUser> implements IMqUserService {

}
