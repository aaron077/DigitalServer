package com.dengwm.client.nettyclient;



import java.net.InetSocketAddress;

import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

import com.dengwm.bean.ClientInfoBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DigitalClient {
	 
    public static void main(String args[]) {
        // Client服务启动器
        ClientBootstrap bootstrap = new ClientBootstrap(
                new NioClientSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool()));
        // 设置一个处理服务端消息和各种消息事件的类(Handler)
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(new MessageClientHandler());
            }
        });
        // 连接到本地的8000端口的服务端
        bootstrap.connect(new InetSocketAddress("127.0.0.1", 9000));
    }
 
    private static class MessageClientHandler extends SimpleChannelHandler {
 
        /**
         * 当绑定到服务端的时候触发，给服务端发消息。
         *  
         * @alia OneCoder
         * @author lihzh
         */
        @Override
        public void channelConnected(ChannelHandlerContext ctx,
                ChannelStateEvent e) {
        	System.out.println("connected start");
            // 将字符串，构造成ChannelBuffer，传递给服务端
            ClientInfoBean bean = new ClientInfoBean();
            bean.setClientId("test");

            ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
            String msg = null;
			try {
				msg = mapper.writeValueAsString(bean);
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("channelConnected msg::" + msg);
            ChannelBuffer buffer = ChannelBuffers.buffer(msg.length());
           
            buffer.writeBytes(msg.getBytes());
            e.getChannel().write(buffer);
        }
    }
 
}