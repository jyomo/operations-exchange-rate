package com.apps.ops.service.impl;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.apps.ops.model.Account;
import com.apps.ops.model.CoreExchange;
import com.apps.ops.model.MovementChange;
import com.apps.ops.service.CoreExchangeService;
import com.apps.ops.util.Constants;

@Service
public class CoreExchangeImpl implements CoreExchangeService {

	private static final Logger logger = LogManager.getLogger(CoreExchangeImpl.class);

	@Override
	public CoreExchange getExchangeData(Optional<Account> sourceAccountOptional,
			Optional<Account> targetAccountOptional, MovementChange movementChange) {
		CoreExchange core = null;
		double tipoCambioDiaCompra = 3.998;
		double tipoCambioDiaVenta = 4.001;
		double tipoCambioDia = 0.0;
		double montoCalculado = 0.0;
		String monedaExchange = movementChange.getCurrency();
		String categoryExchange = "";

		Account sourceAccount;
		Account targetAccount;

		if (sourceAccountOptional.isPresent() && targetAccountOptional.isPresent()) {

			sourceAccount = sourceAccountOptional.get();
			targetAccount = targetAccountOptional.get();
	
			logger.info(String.format("sourceAccount [%s] | targetAccount [%s] | movementChange [%s] " ,
					sourceAccount.getCurrency(), targetAccount.getCurrency(), movementChange.getCurrency()));
			
			if (!sourceAccount.getCurrency().equals(targetAccount.getCurrency())) {
				
				
				

				if (Constants.MONEDA_SOL.equals(sourceAccount.getCurrency())) {
					if (!movementChange.getCurrency().equals(sourceAccount.getCurrency())) { // 500 usd
						
						logger.info(String.format("Exchange-rate [%s] - Iniciando cálculo..." , Constants.CATEGORIA_VENTA));
						montoCalculado = movementChange.getAmount() * tipoCambioDiaVenta; // 2000 sol
						monedaExchange = sourceAccount.getCurrency();
						
						logger.info(String.format("---> MontoCalculadoConversion %s %s", montoCalculado, monedaExchange ));
						
						tipoCambioDia = tipoCambioDiaVenta;
						categoryExchange = Constants.CATEGORIA_VENTA;
					} else {
						logger.info(Constants.VALIDACION_OPERACION_NO_PERMITIDA);
					}

				} else if (Constants.MONEDA_DOLAR.equals(sourceAccount.getCurrency())) {

					logger.info("Exchange-rate" +  Constants.CATEGORIA_COMPRA);

					if (!movementChange.getCurrency().equals(targetAccount.getCurrency())) { // 400 sol
						logger.info(String.format("Exchange-rate [%s] - Iniciando cálculo..." , Constants.CATEGORIA_COMPRA));

						montoCalculado = movementChange.getAmount() / tipoCambioDiaCompra; // 102.5 usd
						monedaExchange = sourceAccount.getCurrency();
						
						logger.info(String.format("---> MontoCalculadoConversion %s %s", montoCalculado, monedaExchange ));

						
						tipoCambioDia = tipoCambioDiaCompra;
						categoryExchange = Constants.CATEGORIA_COMPRA;
					} else {
						logger.info(Constants.VALIDACION_OPERACION_NO_PERMITIDA);
					}
				} else {
					logger.info("sin coincidencias");
				}
				
				
				if (!movementChange.getCurrency().equals(sourceAccount.getCurrency())) {
					logger.info("Exchange-rate calculado..");
					core = new CoreExchange();
					core.setMonedaTipoCambio(monedaExchange);
					core.setMontoCalculado(montoCalculado);
					core.setTipoCambioDia(tipoCambioDia);
					core.setCategoriaCambio(categoryExchange);
					
					
					
					
				} else {
					logger.warn("Exchange-rate no calculado..");
				}
			}
		} else {
			logger.info(Constants.VALIDACION_SOLICITUD_INCORRECTA);
		}

		return core;
	}

}
