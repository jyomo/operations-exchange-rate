package com.apps.ops.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigDecimal id;
	private int sourceAccountId;
	private int targetAccountId;

	private double sourceAmountMovement;
	private double targetAmountMovement;
	private double exchangeRate;
	private String exchangeCurrency;
	private String exchangeCategory;
	private String operationType;

	public Operation() {
		super();
	}

	public Operation(int sourceAccountId, int targetAccountId, double sourceAmountMovement, double targetAmountMovement,
			double exchangeRate, String exchangeCurrency, String exchangeCategory, String operationType) {
		super();
		this.sourceAccountId = sourceAccountId;
		this.targetAccountId = targetAccountId;
		this.sourceAmountMovement = sourceAmountMovement;
		this.targetAmountMovement = targetAmountMovement;
		this.exchangeRate = exchangeRate;
		this.exchangeCurrency = exchangeCurrency;
		this.exchangeCategory = exchangeCategory;
		this.operationType = operationType;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public int getSourceAccountId() {
		return sourceAccountId;
	}

	public void setSourceAccountId(int sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}

	public int getTargetAccountId() {
		return targetAccountId;
	}

	public void setTargetAccountId(int targetAccountId) {
		this.targetAccountId = targetAccountId;
	}

	public double getSourceAmountMovement() {
		return sourceAmountMovement;
	}

	public void setSourceAmountMovement(double sourceAmountMovement) {
		this.sourceAmountMovement = sourceAmountMovement;
	}

	public double getTargetAmountMovement() {
		return targetAmountMovement;
	}

	public void setTargetAmountMovement(double targetAmountMovement) {
		this.targetAmountMovement = targetAmountMovement;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getExchangeCurrency() {
		return exchangeCurrency;
	}

	public void setExchangeCurrency(String exchangeCurrency) {
		this.exchangeCurrency = exchangeCurrency;
	}

	public String getExchangeCategory() {
		return exchangeCategory;
	}

	public void setExchangeCategory(String exchangeCategory) {
		this.exchangeCategory = exchangeCategory;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", sourceAccountId=" + sourceAccountId + ", targetAccountId=" + targetAccountId
				+ ", sourceAmountMovement=" + sourceAmountMovement + ", targetAmountMovement=" + targetAmountMovement
				+ ", exchangeRate=" + exchangeRate + ", exchangeCurrency=" + exchangeCurrency + ", exchangeCategory="
				+ exchangeCategory + ", operationType=" + operationType + ", getId()=" + getId()
				+ ", getSourceAccountId()=" + getSourceAccountId() + ", getTargetAccountId()=" + getTargetAccountId()
				+ ", getSourceAmountMovement()=" + getSourceAmountMovement() + ", getTargetAmountMovement()="
				+ getTargetAmountMovement() + ", getExchangeRate()=" + getExchangeRate() + ", getExchangeCurrency()="
				+ getExchangeCurrency() + ", getExchangeCategory()=" + getExchangeCategory() + ", getOperationType()="
				+ getOperationType() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
