package com.apps.ops.bean;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
//@Component
public class AccountRequest {
	
	private String accountType;
	private String accountNumber;
	private double amount;
	private String currency;
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "AccountRequest [accountType=" + accountType + ", accountNumber=" + accountNumber + ", amount="
				+ amount + ", currency=" + currency + "]";
	}
	
	
	
}
