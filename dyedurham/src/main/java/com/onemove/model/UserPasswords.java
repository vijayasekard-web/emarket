package com.onemove.model;

import java.util.Date;

public class UserPasswords {

	private int id;
	private int portalUserId;
	public UserPasswords(int portalUserId, String password, String passwordSalt) {
		super();
		this.portalUserId = portalUserId;
		this.password = password;
		this.passwordSalt = passwordSalt;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	public UserPasswords(){}
	
	private String password;
	private String passwordSalt;
	private Date createdAt;
	private Date updatedAt;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPortalUserId() {
		return portalUserId;
	}
	public void setPortalUserId(int portalUserId) {
		this.portalUserId = portalUserId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordSalt() {
		return passwordSalt;
	}
	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
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



}
