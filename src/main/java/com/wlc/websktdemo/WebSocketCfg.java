package com.wlc.websktdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Author: wlc
 * @Date: 2020/5/21 20:47
 * @Description:开启WebSocket支持
 **/
@Configuration
public class WebSocketCfg {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
