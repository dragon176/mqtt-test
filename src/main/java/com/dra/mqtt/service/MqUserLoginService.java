package com.dra.mqtt.service;

import com.dra.mqtt.entity.MqUser;

public interface MqUserLoginService {
    MqUser login(String username, String password);
}
