package com.dengwm.server;


import java.util.ArrayList;
import java.util.List;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import com.dengwm.bean.ChatObject;

public class ServerLauncher {

    public static void main(String[] args) throws InterruptedException {

        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(9092);

        final SocketIOServer server = new SocketIOServer(config);

        server.addEventListener("chatevent", ChatObject.class, new DataListener<ChatObject>() {
            public void onData(SocketIOClient client, ChatObject data, AckRequest ackRequest) {
            	System.out.println("username"+data.getUserName());
            	System.out.println("msg"+data.getMessage());
//            	data.setMessage("dwmtest");
//                server.getBroadcastOperations().sendEvent("chatevent", data);
//                data.setMessage("test");
            	List<ChatObject> datas = new ArrayList<ChatObject>();
            	datas.add(data);
            	
                client.sendEvent("chatevent", datas);
            }
        });
        
        server.start();

        Thread.sleep(Integer.MAX_VALUE);

        server.stop();
    }

}
