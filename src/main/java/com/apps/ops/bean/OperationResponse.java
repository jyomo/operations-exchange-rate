package com.apps.ops.bean;

public class OperationResponse {
	private String monedaOrigen;
	private String monedaDestino;
	private double montoContTipoCambio;
	private double tipoCambio;

	public OperationResponse(String monedaOrigen, String monedaDestino, double montoContTipoCambio, double tipoCambio) {
		super();
		this.monedaOrigen = monedaOrigen;
		this.monedaDestino = monedaDestino;
		this.montoContTipoCambio = montoContTipoCambio;
		this.tipoCambio = tipoCambio;
	}

	public String getMonedaOrigen() {
		return monedaOrigen;
	}

	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}

	public String getMonedaDestino() {
		return monedaDestino;
	}

	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}

	public double getMontoContTipoCambio() {
		return montoContTipoCambio;
	}

	public void setMontoContTipoCambio(double montoContTipoCambio) {
		this.montoContTipoCambio = montoContTipoCambio;
	}

	public double getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(double tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

}
