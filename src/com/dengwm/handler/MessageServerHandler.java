package com.dengwm.handler;

import java.io.IOException;
import java.nio.charset.Charset;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.dengwm.bean.ClientInfoBean;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MessageServerHandler extends SimpleChannelHandler{
	/**
	 * 用户接受客户端发来的消息，在有客户端消息到达时触发
	 * 
	 * @author lihzh
	 * @alia OneCoder
	 */
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
		System.out.println("messageReceived");
		ChannelBuffer buffer = (ChannelBuffer) e.getMessage();
		System.out.println(buffer.toString(Charset.defaultCharset()));
		System.out.println("MessageServerHandler::messageReceived buffer:: "+buffer.toString(Charset.defaultCharset()));
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		ClientInfoBean bean = null;
		try {
			bean = mapper.readValue(buffer.toString(Charset.defaultCharset()), ClientInfoBean.class);
			System.out.println(bean.getClientId());
		} catch (JsonParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(buffer.toString(Charset.defaultCharset()));
	}
}
