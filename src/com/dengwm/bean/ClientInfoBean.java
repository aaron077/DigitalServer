package com.dengwm.bean;
/**
 * 终端信息类
* @Description: TODO(这里用一句话描述这个类的作用) 
* @ClassName: ClientInfoBean
* @author dengwm
* @date 2013-4-30 下午9:36:06
 */
public class ClientInfoBean {
	private String clientId;
	private String clientName;
	private String region;
	private String insertTime;
	private String updateTime;
	
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
}
