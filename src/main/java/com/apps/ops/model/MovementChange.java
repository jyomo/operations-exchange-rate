package com.apps.ops.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovementChange {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double amount;
	private String currency;
	private Date date;

	public MovementChange() {
		super();
	}
	public MovementChange(double amount, String currency) {
		super();
		this.amount = amount;
		this.currency = currency;
	}

	public MovementChange(double amount, String currency, Date date) {
		super();
		this.amount = amount;
		this.currency = currency;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Movement [id=" + id + ", amount=" + amount + ", currency=" + currency + ", date=" + date + "]";
	}

}