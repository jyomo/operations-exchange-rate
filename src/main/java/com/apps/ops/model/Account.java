package com.apps.ops.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account
		extends BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String accountType;
	private String accountNumber;
	private double ammount;
	private String currency;
	private boolean status;

	public Account() {
		super();
	}

	public Account(String accountType, String accountNumber, double ammount, String currency, boolean status) {
		super();
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.ammount = ammount;
		this.currency = currency;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
		return ammount;
	}

	public void setAmount(double mount) {
		this.ammount = mount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountType=" + accountType + ", accountNumber=" + accountNumber + ", mount="
				+ ammount + ", currency=" + currency + ", status=" + status + "]";
	}

	@Override
	public boolean deposit(double amount) {
		this.ammount += amount;
		return true;

	}

	@Override
	public boolean withdraw(double amount) {
		if (this.ammount < amount) {
			return false;
		} else {
			this.ammount -= amount;
			return true;
		}

	}

}