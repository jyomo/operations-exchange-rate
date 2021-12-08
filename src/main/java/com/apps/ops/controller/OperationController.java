package com.apps.ops.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apps.ops.bean.OperationRequest;
import com.apps.ops.model.Account;
import com.apps.ops.model.MovementChange;
import com.apps.ops.service.AccountService;
import com.apps.ops.service.OperationService;
import com.apps.ops.util.Constants;
import com.apps.ops.util.ResponseJson;

@RestController
public class OperationController {
	private static final Logger logger = LogManager.getLogger(OperationController.class);
	@Autowired
	private AccountService accountService;

	@Autowired
	private OperationService operationService;

	@PostMapping("/transfer")
	public ResponseJson transfer(@RequestBody OperationRequest operationRequest) {
		logger.info("---transfer---");
		logger.info(operationRequest);
		Optional<Account> sourceAccount = accountService.findById(operationRequest.getSourceAccountId());
		Optional<Account> targetAccount = accountService.findById(operationRequest.getTargetAccountId());

		if (sourceAccount.isPresent() && targetAccount.isPresent()) {

			String format = String.format("cuentaOrigen [%s]", sourceAccount.get().toString());
			logger.info(format);
			format = String.format("cuentaDestino [%s]", targetAccount.get().toString());
			logger.info(format);

			MovementChange movementChange = new MovementChange(operationRequest.getAmountMovement(),
					operationRequest.getCurrencyMovement());
			format = String.format("movementChange [%s]", movementChange.toString());
			logger.info(format);
			return operationService.transfer(sourceAccount, targetAccount, movementChange);
		} else {
			logger.info("Datos no encontrados: " + Constants.VALIDACION_SOLICITUD_INCORRECTA);
			return new ResponseJson(Constants.HTTP_BAD_REQUEST_STATUS, Constants.VALIDACION_SOLICITUD_INCORRECTA);
		}

	}

	@GetMapping("/operations")
	public ResponseJson list() {
		logger.info("---list operations---");
		return new ResponseJson(Constants.HTTP_OK_STATUS, operationService.list());

	}
}
