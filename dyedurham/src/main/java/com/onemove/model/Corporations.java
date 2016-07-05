package com.onemove.model;

import java.util.Date;

public class Corporations {

	private int corporationId;
	private int corporationCode;
	private String corporationType;
	private String companyName;
	private String suiteNumber;
	private String streetNumber;
	private String street;
	private String city;
	private String province;
	private String postalCode;
	private String country;
	private String phone;
	private String fax;
	private String email;
	private int accountNumber;
	private float currentBalance;
	private float balanceLow;
	private float balanceTopup;
	private String billingContactName;
	private String billingContactAddress1;
	private String billingContactAddress2;
	private String billingContactCity;
	private String billingContactProvince;
	private String billingContactCountry;
	private String billingContactPostalCode;
	private String billingContactPhone;
	private String billingContactEmail;
	private int paymentMethod;
	private boolean isClientConsentToAutoChargeCreditCard;
	private boolean isCardTransactionReceiptEnabled;
	private String token;
	private Date tokenExpiryDate;
	private int cardTransactionAttempts;
	private Date balanceLowTriggeredAt;
	private String beanStreamCustomerCode;
	private Date createdAt;
	private Date updatedAt;
	private String beanstreamPartialCreditCardNumber;
	private int overdraftOption;
	private float overDraftLimit;

	public int getCorporationId() {
		return corporationId;
	}
	public void setCorporationId(int corporationId) {
		this.corporationId = corporationId;
	}
	public int getCorporationCode() {
		return corporationCode;
	}
	public void setCorporationCode(int corporationCode) {
		this.corporationCode = corporationCode;
	}
	public String getCorporationType() {
		return corporationType;
	}
	public void setCorporationType(String corporationType) {
		this.corporationType = corporationType;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSuiteNumber() {
		return suiteNumber;
	}
	public void setSuiteNumber(String suiteNumber) {
		this.suiteNumber = suiteNumber;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public float getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(float currentBalance) {
		this.currentBalance = currentBalance;
	}
	public float getBalanceLow() {
		return balanceLow;
	}
	public void setBalanceLow(float balanceLow) {
		this.balanceLow = balanceLow;
	}
	public float getBalanceTopup() {
		return balanceTopup;
	}
	public void setBalanceTopup(float balanceTopup) {
		this.balanceTopup = balanceTopup;
	}
	public String getBillingContactName() {
		return billingContactName;
	}
	public void setBillingContactName(String billingContactName) {
		this.billingContactName = billingContactName;
	}
	public String getBillingContactAddress1() {
		return billingContactAddress1;
	}
	public void setBillingContactAddress1(String billingContactAddress1) {
		this.billingContactAddress1 = billingContactAddress1;
	}
	public String getBillingContactAddress2() {
		return billingContactAddress2;
	}
	public void setBillingContactAddress2(String billingContactAddress2) {
		this.billingContactAddress2 = billingContactAddress2;
	}
	public String getBillingContactCity() {
		return billingContactCity;
	}
	public void setBillingContactCity(String billingContactCity) {
		this.billingContactCity = billingContactCity;
	}
	public String getBillingContactProvince() {
		return billingContactProvince;
	}
	public void setBillingContactProvince(String billingContactProvince) {
		this.billingContactProvince = billingContactProvince;
	}
	public String getBillingContactCountry() {
		return billingContactCountry;
	}
	public void setBillingContactCountry(String billingContactCountry) {
		this.billingContactCountry = billingContactCountry;
	}
	public String getBillingContactPostalCode() {
		return billingContactPostalCode;
	}
	public void setBillingContactPostalCode(String billingContactPostalCode) {
		this.billingContactPostalCode = billingContactPostalCode;
	}
	public String getBillingContactPhone() {
		return billingContactPhone;
	}
	public void setBillingContactPhone(String billingContactPhone) {
		this.billingContactPhone = billingContactPhone;
	}
	public String getBillingContactEmail() {
		return billingContactEmail;
	}
	public void setBillingContactEmail(String billingContactEmail) {
		this.billingContactEmail = billingContactEmail;
	}
	public int getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(int paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public boolean getIsClientConsentToAutoChargeCreditCard() {
		return isClientConsentToAutoChargeCreditCard;
	}
	public void setIsClientConsentToAutoChargeCreditCard(boolean isClientConsentToAutoChargeCreditCard) {
		this.isClientConsentToAutoChargeCreditCard = isClientConsentToAutoChargeCreditCard;
	}
	public boolean getIsCardTransactionReceiptEnabled() {
		return isCardTransactionReceiptEnabled;
	}
	public void setIsCardTransactionReceiptEnabled(boolean isCardTransactionReceiptEnabled) {
		this.isCardTransactionReceiptEnabled = isCardTransactionReceiptEnabled;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getTokenExpiryDate() {
		return tokenExpiryDate;
	}
	public void setTokenExpiryDate(Date tokenExpiryDate) {
		this.tokenExpiryDate = tokenExpiryDate;
	}
	public int getCardTransactionAttempts() {
		return cardTransactionAttempts;
	}
	public void setCardTransactionAttempts(int cardTransactionAttempts) {
		this.cardTransactionAttempts = cardTransactionAttempts;
	}
	public Date getBalanceLowTriggeredAt() {
		return balanceLowTriggeredAt;
	}
	public void setBalanceLowTriggeredAt(Date balanceLowTriggeredAt) {
		this.balanceLowTriggeredAt = balanceLowTriggeredAt;
	}
	public String getBeanStreamCustomerCode() {
		return beanStreamCustomerCode;
	}
	public void setBeanStreamCustomerCode(String beanStreamCustomerCode) {
		this.beanStreamCustomerCode = beanStreamCustomerCode;
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
	public String getBeanstreamPartialCreditCardNumber() {
		return beanstreamPartialCreditCardNumber;
	}
	public void setBeanstreamPartialCreditCardNumber(String beanstreamPartialCreditCardNumber) {
		this.beanstreamPartialCreditCardNumber = beanstreamPartialCreditCardNumber;
	}
	public int getOverdraftOption() {
		return overdraftOption;
	}
	public void setOverdraftOption(int overdraftOption) {
		this.overdraftOption = overdraftOption;
	}
	public float getOverDraftLimit() {
		return overDraftLimit;
	}
	public void setOverDraftLimit(float overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}




}
