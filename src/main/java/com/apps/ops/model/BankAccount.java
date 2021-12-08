package com.apps.ops.model;
import javax.persistence.Entity;

public abstract class BankAccount {
	public abstract boolean deposit(double amount);
	public abstract boolean withdraw(double amount);
}
