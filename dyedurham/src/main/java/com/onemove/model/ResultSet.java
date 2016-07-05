package com.onemove.model;

public class ResultSet {

	boolean success;
	String userId;
	String userName;
	String email;
	String firstName;
	String middleName;
	String LastName;
	int corporationId;
	String corporationLogoURL;
	int failureCode;
	String failureMessage;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getCorporationId() {
		return corporationId;
	}
	public void setCorporationId(int corporationId) {
		this.corporationId = corporationId;
	}
	public String getCorporationLogoURL() {
		return corporationLogoURL;
	}
	public void setCorporationLogoURL(String corporationLogoURL) {
		this.corporationLogoURL = corporationLogoURL;
	}
	public int getFailureCode() {
		return failureCode;
	}
	public void setFailureCode(int failureCode) {
		this.failureCode = failureCode;
	}
	public String getFailureMessage() {
		return failureMessage;
	}
	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}

	
}
