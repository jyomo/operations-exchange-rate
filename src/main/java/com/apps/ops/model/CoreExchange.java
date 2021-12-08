package com.apps.ops.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.apps.ops.util.Constants;

@Entity
public class CoreExchange {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double montoCalculado;
	private String monedaTipoCambio;
	private double tipoCambioDia;
	private String categoriaCambio;

	public CoreExchange() {
		super();
	}

	public CoreExchange(double montoCalculado, String monedaExchange, double tipoCambioDia, String categoriaCambio) {
		super();
		this.montoCalculado = montoCalculado;
		this.monedaTipoCambio = monedaExchange;
		this.tipoCambioDia = tipoCambioDia;
		this.categoriaCambio=categoriaCambio;
	}

	public double getMontoCalculado() {
		return montoCalculado;
	}

	public void setMontoCalculado(double montoCalculado) {
		this.montoCalculado = montoCalculado;
	}

	public String getMonedaTipoCambio() {
		return monedaTipoCambio;
	}

	public void setMonedaTipoCambio(String monedaTipoCambio) {
		this.monedaTipoCambio = monedaTipoCambio;
	}

	public double getTipoCambioDia() {
		return tipoCambioDia;
	}

	public void setTipoCambioDia(double tipoCambioDia) {
		this.tipoCambioDia = tipoCambioDia;
	}

	public String getCategoriaCambio() {
		return categoriaCambio;
	}

	public void setCategoriaCambio(String categoriaCambio) {
		this.categoriaCambio = categoriaCambio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CoreExchange [id=" + id + ", montoCalculado=" + montoCalculado + ", monedaTipoCambio="
				+ monedaTipoCambio + ", tipoCambioDia=" + tipoCambioDia + ", categoriaCambio=" + categoriaCambio + "]";
	}
	
	
	
	

}
