package com.onemove.model;

public class LoginRequests {
	
	private int id;
	private String ipAddress;
	private String sourceIpAddress;
	private String userName;
	private int corporationId;
	private boolean result;
	private int failureCode;
	private int appCode;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getCorporationId() {
		return corporationId;
	}
	public void setCorporationId(int corporationId) {
		this.corporationId = corporationId;
	}
	public boolean getResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public int getFailureCode() {
		return failureCode;
	}
	public void setFailureCode(int failureCode) {
		this.failureCode = failureCode;
	}
	public int getAppCode() {
		return appCode;
	}
	public void setAppCode(int appCode) {
		this.appCode = appCode;
	}
	public String getSourceIpAddress() {
		return sourceIpAddress;
	}
	public void setSourceIpAddress(String sourceIpAddress) {
		this.sourceIpAddress = sourceIpAddress;
	}

}
