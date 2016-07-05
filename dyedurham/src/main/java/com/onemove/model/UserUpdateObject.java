package com.onemove.model;

import java.util.Date;

public class UserUpdateObject {
	
	private String adminUserName;
	private String adminPassword;
	private String ipAddress;
	private int appCode;
	private String firstName;
	private String password;
	private int roleId;
	private String lastName;
	private String email;
	private String startPath;
	private int isConfirmationRequired;
	private String confirmationKey;
	private Date passwordChangedAt;
	private Integer isPasswordExpired;
	private String userName;
	private int corporationId;
	private int hasAgreedToTerms;
	private int attempts;
	private Date lockedAt;
	private Date createdAt;
	private Date updatedAt;
	
	public String getAdminUserName() {
		return adminUserName;
	}
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStartPath() {
		return startPath;
	}
	public void setStartPath(String startPath) {
		this.startPath = startPath;
	}
	public int getIsConfirmationRequired() {
		return isConfirmationRequired;
	}
	public void setIsConfirmationRequired(int isConfirmationRequired) {
		this.isConfirmationRequired = isConfirmationRequired;
	}
	public String getConfirmationKey() {
		return confirmationKey;
	}
	public void setConfirmationKey(String confirmationKey) {
		this.confirmationKey = confirmationKey;
	}
	public Date getPasswordChangedAt() {
		return passwordChangedAt;
	}
	public void setPasswordChangedAt(Date passwordChangedAt) {
		this.passwordChangedAt = passwordChangedAt;
	}
	public Integer getIsPasswordExpired() {
		return isPasswordExpired;
	}
	public void setIsPasswordExpired(Integer isPasswordExpired) {
		this.isPasswordExpired = isPasswordExpired;
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
	public int getHasAgreedToTerms() {
		return hasAgreedToTerms;
	}
	public void setHasAgreedToTerms(int hasAgreedToTerms) {
		this.hasAgreedToTerms = hasAgreedToTerms;
	}
	public int getAttempts() {
		return attempts;
	}
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	public Date getLockedAt() {
		return lockedAt;
	}
	public void setLockedAt(Date lockedAt) {
		this.lockedAt = lockedAt;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public int getAppCode() {
		return appCode;
	}
	public void setAppCode(int addCode) {
		this.appCode = addCode;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	

	
}
