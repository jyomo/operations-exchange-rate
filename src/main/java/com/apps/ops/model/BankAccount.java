package com.apps.ops.model;

public interface BankAccount {
	
	public double getBalance();
	
	public boolean deposit(double amount);

	public boolean withdraw(double amount);
}
