package com.apps.ops.service.impl;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.ops.model.Account;
import com.apps.ops.model.CoreExchange;
import com.apps.ops.model.MovementChange;
import com.apps.ops.service.CoreExchangeService;
import com.apps.ops.service.LeerDatosService;
import com.apps.ops.util.Constants;

@Service
public class CoreExchangeImpl implements CoreExchangeService {

//	private double tipoCambioDiaCompra = 3.998;
//	private double tipoCambioDiaVenta = 4.001;
	

	@Autowired
	private LeerDatosService leerDatosService;	

	private static final Logger logger = LogManager.getLogger(CoreExchangeImpl.class);

	private double tipoCambioCompra() {
		return leerDatosService.leerTipoCambioVenta();
	}
	private double tipoCambioVenta() {
		return leerDatosService.leerTipoCambioVenta();
	}
	
	
	private double calculoTipoCambioCompra(double amountChange) {

		double tipoCambioDiaCompra =leerDatosService.leerTipoCambioVenta();
		logger.info("tipoCambioDiaCompra Proveedor: {}", tipoCambioDiaCompra);
		
		return amountChange / tipoCambioDiaCompra;
	}

	private double calculoTipoCambioVenta(double amountChange) {
		double tipoCambioDiaCompra =leerDatosService.leerTipoCambioVenta();
		logger.info("tipoCambioDiaCompra Proveedor: {}", tipoCambioDiaCompra);
		return amountChange * tipoCambioDiaCompra;
	}

	@Override
	public CoreExchange getExchangeData(Optional<Account> sourceAccountOptional,
			Optional<Account> targetAccountOptional, MovementChange movementChange) {

		CoreExchange core = null;
		if (sourceAccountOptional.isPresent() && targetAccountOptional.isPresent()) {
			Account sourceAccount = sourceAccountOptional.get();
			Account targetAccount = targetAccountOptional.get();
			logger.info("sourceAccount: {} | targetAccount: {} | movementChange: {} ", sourceAccount.getCurrency(), targetAccount.getCurrency(), movementChange.getCurrency());

			if (!sourceAccount.getCurrency().equals(targetAccount.getCurrency())) { // monedas ctas diferentes
				if (!sourceAccount.getCurrency().equals(movementChange.getCurrency())) { // CASO 1 (VTA) Y CASO 3
					return obtenerCalculoTipoCambio(sourceAccount, movementChange);

				} else logger.error("Moneda Origen igual a MonedaCambio {}", Constants.VALIDACION_OPERACION_NO_PERMITIDA);
			} else logger.error("No aplica lógica para ctas de monedas iguales");
		} else logger.info(Constants.VALIDACION_SOLICITUD_INCORRECTA + "Datos nulos");
		return core;
	}

	private CoreExchange obtenerCalculoTipoCambio(Account sourceAccount, MovementChange movementChange) {
		logger.info("Exchange-rate - Iniciando cálculo.");
		String monedaExchange = sourceAccount.getCurrency();
		double montoCalculado = Constants.MONEDA_SOL.equals(movementChange.getCurrency())
				? this.calculoTipoCambioCompra(movementChange.getAmount())
				: this.calculoTipoCambioVenta(movementChange.getAmount());
		double tipoCambioDia = Constants.MONEDA_SOL.equals(movementChange.getCurrency()) ? this.tipoCambioCompra()
				: this.tipoCambioVenta();
		String categoryExchange = Constants.MONEDA_SOL.equals(movementChange.getCurrency()) ? Constants.CATEGORIA_COMPRA
				: Constants.CATEGORIA_VENTA;
		// enviar 500 USD desde (S/. 10000) a (6000 USD) ----> //compra usd y monto 		calculado: S/. 500 *4 
		//enviar S/. 400 desde (6000 USD) a (S/. 10000)		---->vende usd y monto calculado: usd 400 /3.9
		logger.info("---> MontoCalculadoConversion {} {}", montoCalculado, monedaExchange);
		logger.info("Categoría {}", Constants.CATEGORIA_VENTA);
		return new CoreExchange(montoCalculado, monedaExchange, tipoCambioDia, categoryExchange);
	}

}
