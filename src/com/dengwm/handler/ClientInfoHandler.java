package com.dengwm.handler;

import com.dengwm.utils.CommonConstants;

public class ClientInfoHandler implements MyHandler{

	@Override
	public void onReceived(Object bean, int oper) {
		// TODO Auto-generated method stub
//		对象强转，根据具体操作，做相应业务
		if(CommonConstants.OPER_ADD == oper){
			
		}
	}

}
