package com.apps.ops.util;

public class Constants {

	private Constants() {
		throw new IllegalStateException("Clase Utilitaria");
	}

	public static final String TRANSFERENCIA = "TRANSFERENCIA";
	public static final String TIPO_CAMBIO = "TIPO_CAMBIO";
	public static final String MONEDA_SOL = "SOL";
	public static final String MONEDA_DOLAR = "USD";
	public static final String CATEGORIA_VENTA = "VENTA";
	public static final String CATEGORIA_COMPRA = "COMPRA";
	public static final String OPERACION_EXITOSA = "Operación exitosa.";
	public static final String OPERACION_FALLIDA = "Operación fallida.";
	public static final String VALIDACION_SALDO_NO_DISPONIBLE = "Saldo no disponible para la transferencia.";
	public static final String VALIDACION_MONEDA_INCORRECTA = "Elija otra moneda.";
	public static final String VALIDACION_OPERACION_NO_PERMITIDA = "Operación no permitida.";
	public static final String VALIDACION_SOLICITUD_INCORRECTA = "Solicitud incorrecta";
	public static final String VALIDACION_BALANCE_EXITOSO = "Validación de balance exitosa.";

	public static final Integer HTTP_OK_STATUS = 200;
	public static final Integer HTTP_BAD_REQUEST_STATUS = 400;
	public static final Integer HTTP_NOT_FOUND_STATUS = 404;
}
