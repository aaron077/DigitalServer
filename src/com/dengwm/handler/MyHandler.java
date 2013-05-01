package com.dengwm.handler;
/**
 * 事件处理类
* @Description: TODO(这里用一句话描述这个类的作用) 
* @ClassName: MyHandler
* @author dengwm
* @date 2013-4-30 下午9:27:32
 */
public interface MyHandler {
/**
 *收到具体事件的处理方法，oper:操作
* @Description: TODO(这里用一句话描述这个方法的作用) 
* @Title: onReceived 
* @return void    返回类型 
* @throws
 */
	public void onReceived(Object bean,int oper);
}
