package com.apps.ops.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account implements BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String code;
	private double balance;
	private String currency;
	private boolean status;

	public Account() {
		super();
	}

	public Account(String accountType, String accountNumber, double balance, String currency, boolean status) {
		super();
		this.name = accountType;
		this.code = accountNumber;
		this.balance = balance;
		this.currency = currency;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
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
		return "Account [id=" + id + ", name=" + name + ", code=" + code + ", balance="
				+ balance + ", currency=" + currency + ", status=" + status + "]";
	}

	@Override
	public boolean deposit(double balance) {
		this.balance += balance;
		return true;

	}

	@Override
	public boolean withdraw(double balance) {
		if (this.balance < balance) {
			return false;
		} else {
			this.balance -= balance;
			return true;
		}

	}

}