package com.dra.mqtt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.http.HttpServlet;

/**
 * <p>
 * MQTT启动类
 * </p>
 *
 * @author: dra
 * @since: 2022/5/22
 */
@SpringBootApplication
@MapperScan("com.dra.mqtt.mapper")
public class ApplicationMQTT {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMQTT.class,args);
    }
}
