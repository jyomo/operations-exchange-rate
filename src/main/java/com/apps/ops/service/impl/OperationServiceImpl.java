package com.apps.ops.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.ops.bean.OperationResponse;
import com.apps.ops.model.Account;
import com.apps.ops.model.CoreExchange;
import com.apps.ops.model.MovementChange;
import com.apps.ops.model.Operation;
import com.apps.ops.repository.AccountRepository;
import com.apps.ops.repository.OperationRepository;
import com.apps.ops.service.CoreExchangeService;
import com.apps.ops.service.OperationService;
import com.apps.ops.util.Constants;
import com.apps.ops.util.ResponseJson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class OperationServiceImpl implements OperationService {
	private static final Logger logger = LogManager.getLogger(OperationServiceImpl.class);

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private OperationRepository operationRepository;

	@Autowired
	private CoreExchangeService coreExchangeService;

	@Override
	public List<Operation> list() {
		List<Operation> data= operationRepository.findAll();
		logger.info("Ctd Registros obtenidos: {}", data.size());
		return data;
	}

	@Override
	public void save(Operation operation) {
		logger.info("Registrando data...");
		operationRepository.save(operation);
		logger.info("Registro exitoso.");
	}

	@Override
	public ResponseJson transfer(Optional<Account> sourceAccountOptional, Optional<Account> targetAccountOptional,
			MovementChange movementChange) {

		logger.info("1. Validando transferencia...");

		if (sourceAccountOptional.isPresent() && targetAccountOptional.isPresent()) {
			Account sourceAccount = sourceAccountOptional.get();
			Account targetAccount = targetAccountOptional.get();
			sourceAccount.toString();
			targetAccount.toString();
			movementChange.toString();

			logger.info("2. Iniciando transferencia");
			if (sourceAccount.getCurrency().equals(targetAccount.getCurrency())) {
				if (sourceAccount.getCurrency().equals(movementChange.getCurrency())) {

					logger.info("CASO 1. MonedaOrigen [{}] , MonedaDestino [{}] y  monedaTransferencia [{}] son iguales",
							sourceAccount.getCurrency(), targetAccount.getCurrency(), movementChange.getCurrency());

					boolean withdrawSuccess = sourceAccount.withdraw(movementChange.getAmount());
					boolean depositSuccess = targetAccount.deposit(movementChange.getAmount());

					if (withdrawSuccess && depositSuccess) {

						logger.info(Constants.VALIDACION_BALANCE_EXITOSO);
						accountRepository.save(sourceAccount);
						logger.info("Cuenta actualizada correctamente.");

						Operation operacionSinTipoCambio = new Operation();
						operacionSinTipoCambio.setSourceAccountId(sourceAccount.getId());
						operacionSinTipoCambio.setTargetAccountId(targetAccount.getId());
						operacionSinTipoCambio.setExchangeRate(0);
						operacionSinTipoCambio.setExchangeCategory(null);
						operacionSinTipoCambio.setExchangeCurrency(null);
						operacionSinTipoCambio.setSourceAmountMovement(movementChange.getAmount());
						operacionSinTipoCambio.setTargetAmountMovement(movementChange.getAmount());
						operacionSinTipoCambio.setOperationType(Constants.TRANSFERENCIA);
						logger.info("Registrando operación...");
						operationRepository.save(operacionSinTipoCambio);

						logger.info(Constants.OPERACION_EXITOSA);
						return new ResponseJson(Constants.HTTP_OK_STATUS,
								new OperationResponse(sourceAccount.getCurrency(), targetAccount.getCurrency(), 0, 0));
					} else {

						logger.info(Constants.HTTP_NOT_FOUND_STATUS);
						return new ResponseJson(Constants.HTTP_NOT_FOUND_STATUS,
								Constants.VALIDACION_SALDO_NO_DISPONIBLE);
					}

				} else {
					logger.info("CASO 2. MonedaOrigen [{}] , MonedaDestino [{}] iguales pero monedaTransferencia [{}] diferente",
							sourceAccount.getCurrency(), targetAccount.getCurrency(), movementChange.getCurrency());
					logger.info(Constants.VALIDACION_MONEDA_INCORRECTA);

					return new ResponseJson(Constants.HTTP_BAD_REQUEST_STATUS, Constants.VALIDACION_MONEDA_INCORRECTA);
				}
			} else {
				logger.info("CASO 3Y4. MonedaOrigen {} y MonedaDestino {} diferentes", sourceAccount.getCurrency(),targetAccount.getCurrency());
			}

			CoreExchange coreExchange = coreExchangeService.getExchangeData(sourceAccountOptional,
					targetAccountOptional, movementChange);
			if (coreExchange == null) {
				return new ResponseJson(Constants.HTTP_BAD_REQUEST_STATUS, Constants.VALIDACION_OPERACION_NO_PERMITIDA);
			}

			logger.info("2. obteniendo datos de coreExchange");

			String dataCoreExchange=coreExchange.toString();
			logger.info(dataCoreExchange);


			Operation operation = null;

			operation = new Operation();

			operation.setSourceAccountId(sourceAccount.getId());
			operation.setTargetAccountId(targetAccount.getId());

			operation.setExchangeRate(coreExchange.getTipoCambioDia());
			operation.setExchangeCategory(coreExchange.getCategoriaCambio());
			operation.setExchangeCurrency(coreExchange.getMonedaTipoCambio());
			operation.setSourceAmountMovement(coreExchange.getMontoCalculado());
			operation.setTargetAmountMovement(movementChange.getAmount());

			operation.setOperationType(Constants.TIPO_CAMBIO);
			operation.setOperationType(operation.getOperationType());

			if (targetAccount.getCurrency().equals(movementChange.getCurrency())) {
				boolean withdrawSuccess = sourceAccount.withdraw(coreExchange.getMontoCalculado());
				boolean depositSuccess = targetAccount.deposit(movementChange.getAmount());

				if (withdrawSuccess && depositSuccess) {
					logger.info(Constants.VALIDACION_BALANCE_EXITOSO);
					accountRepository.save(sourceAccount);
					logger.info("Cuenta actualizada correctamente.");

					logger.info("Registrando operación...");

					String dataOperation=operation.toString();
					logger.info(dataOperation);

					operationRepository.save(operation);
					logger.info(Constants.OPERACION_EXITOSA);


					return new ResponseJson(Constants.HTTP_OK_STATUS,
							new OperationResponse(sourceAccount.getCurrency(), targetAccount.getCurrency(),
									coreExchange.getMontoCalculado(), coreExchange.getTipoCambioDia()));
				} else {
					logger.info(Constants.VALIDACION_SALDO_NO_DISPONIBLE);
					return new ResponseJson(Constants.HTTP_NOT_FOUND_STATUS, Constants.VALIDACION_SALDO_NO_DISPONIBLE);
				}
			} else {
				logger.info(Constants.VALIDACION_OPERACION_NO_PERMITIDA);
				return new ResponseJson(Constants.HTTP_BAD_REQUEST_STATUS, Constants.VALIDACION_OPERACION_NO_PERMITIDA);
				//sourceAccount = withdraw(movementChange.getAmount())
				//sourceAccount = deposit(coreExchange.getMontoCalculado())
			}

		} else {
			logger.info(Constants.VALIDACION_SOLICITUD_INCORRECTA);
			return new ResponseJson(Constants.HTTP_BAD_REQUEST_STATUS, Constants.VALIDACION_SOLICITUD_INCORRECTA);
		}

	}

}
