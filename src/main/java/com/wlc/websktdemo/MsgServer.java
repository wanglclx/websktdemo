package com.wlc.websktdemo;

import org.springframework.stereotype.Component;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @Author: wlc
 * @Date: 2020/5/21 20:49
 * @Description:
 **/
@ServerEndpoint("/msgServer")
@Component
public class MsgServer {

    private  Session session;
    @OnOpen
    public void onOpen(Session newSession) {
        session = newSession;
    }

    public void sendMessage(String msg) throws IOException {
        session.getBasicRemote().sendText(msg);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        if(null != message){
            try {
                for (int i = 0; i < 5; i++){
                    Thread.sleep(1000);
                    this.sendMessage("第" + i + "次发送，你好：" + message);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
