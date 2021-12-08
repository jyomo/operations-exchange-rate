package com.apps.ops.util;

import org.springframework.stereotype.Component;

@Component
public class Constants {
	final public static String TRANSFERENCIA = "TRANSFERENCIA";
	final public static String TIPO_CAMBIO = "TIPO_CAMBIO";
	final public static String MONEDA_SOL = "SOL";
	final public static String MONEDA_DOLAR = "USD";
	final public static String CATEGORIA_VENTA = "VENTA";
	final public static String CATEGORIA_COMPRA = "COMPRA";	
	final public static String OPERACION_EXITOSA = "Operación exitosa.";
	final public static String OPERACION_FALLIDA = "Operación fallida.";
	final public static String VALIDACION_SALDO_NO_DISPONIBLE = "Saldo no disponible para la transferencia.";
	final public static String VALIDACION_MONEDA_INCORRECTA = "Elija otra moneda.";
	final public static String VALIDACION_OPERACION_NO_PERMITIDA = "Operación no permitida.";
	final public static String VALIDACION_SOLICITUD_INCORRECTA = "Solicitud incorrecta";
	final public static String VALIDACION_BALANCE_EXITOSO = "Validación de balance exitosa.";
	
	final public static Integer HTTP_OK_STATUS = 200;
	final public static Integer HTTP_BAD_REQUEST_STATUS= 400;
	final public static Integer HTTP_NOT_FOUND_STATUS = 404;
}
