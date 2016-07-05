package com.onemove.model;

import java.io.Serializable;
import java.util.Date;

public class PortalUsers implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private String firstName;
	private String password;
	private int roleId;
	private String passwordSalt;
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
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getPasswordSalt() {
		return passwordSalt;
	}
	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
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
		return this.isConfirmationRequired;
	}
	public void setIsConfirmationRequired(int isConfirmationRequired) {
		this.isConfirmationRequired = isConfirmationRequired;
	}
	public Integer getIsPasswordExpired() {
		return this.isPasswordExpired;
	}
	public void setIsPasswordExpired(Integer isPasswordExpired) {
		this.isPasswordExpired = isPasswordExpired;
	}
	public int getHasAgreedToTerms() {
		return this.hasAgreedToTerms;
	}
	public void setHasAgreedToTerms(int hasAgreedToTerms) {
		this.hasAgreedToTerms = hasAgreedToTerms;
	}
	public String getConfirmationKey() {
		return this.confirmationKey;
	}
	public void setConfirmationKey(String confirmationKey) {
		this.confirmationKey = confirmationKey;
	}
	public Date getPasswordChangedAt() {
		return this.passwordChangedAt;
	}
	public void setPasswordChangedAt(Date passwordChangedAt) {
		this.passwordChangedAt = passwordChangedAt;
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

	public int getAttempts() {
		return this.attempts;
	}
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	public Date getLockedAt() {
		return this.lockedAt;
	}
	public void setLockedAt(Date lockedAt) {
		this.lockedAt = lockedAt;
	}
	public Date getCreatedAt() {
		return this.createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return this.updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	
	
	
	
	
	
	
}
