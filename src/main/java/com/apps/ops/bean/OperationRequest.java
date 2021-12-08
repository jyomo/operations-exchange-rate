package com.apps.ops.bean;

public class OperationRequest {
	private int sourceAccountId;
	private int targetAccountId;
	private double amountMovement;
	private String currencyMovement;

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

	public double getAmountMovement() {
		return amountMovement;
	}

	public void setAmountMovement(double amountMovement) {
		this.amountMovement = amountMovement;
	}

	public String getCurrencyMovement() {
		return currencyMovement;
	}

	public void setCurrencyMovement(String currencyMovement) {
		this.currencyMovement = currencyMovement;
	}

	@Override
	public String toString() {
		return "OperationRequest [sourceAccountId=" + sourceAccountId + ", targetAccountId=" + targetAccountId
				+ ", amountMovement=" + amountMovement + ", currencyMovement=" + currencyMovement + "]";
	}

}
