package com.apps.ops.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apps.ops.bean.AccountRequest;
import com.apps.ops.model.Account;
import com.apps.ops.service.AccountService;
import com.apps.ops.service.LeerDatosService;
import com.apps.ops.util.Constants;
import com.apps.ops.util.ResponseJson;

@RestController
public class AccountController {

	private static final Logger logger = LogManager.getLogger(AccountController.class);

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private LeerDatosService leerDatosService;

	@PostMapping("/accounts")
	public ResponseJson saveAccount(@RequestBody AccountRequest accountRequest) {

		logger.info("---saveAccount---");
		logger.info(accountRequest);
		Account account = new Account();
		account.setCode(accountRequest.getAccountNumber());
		account.setName(accountRequest.getAccountType());
		account.setBalance(accountRequest.getAmount());
		account.setCurrency(accountRequest.getCurrency());
		account.setStatus(true);

		accountService.registerAccount(account);
		return new ResponseJson(Constants.HTTP_OK_STATUS, Constants.OPERACION_EXITOSA);
	}

	@GetMapping("/accounts")
	public ResponseJson list() {
		logger.info("---listAccounts---");
		return new ResponseJson(Constants.HTTP_OK_STATUS, accountService.list());
	}
	
	@GetMapping("/tipocambio")
	public ResponseJson listTipoCambio() {
		logger.info("---tipocambio---");
		double data=leerDatosService.leerTipoCambioVenta();
		return new ResponseJson(Constants.HTTP_OK_STATUS, data);
	}

	@GetMapping("/accounts/{id}")
	public ResponseJson getById(@PathVariable Integer id) {		
		logger.info("---/accounts/{}---", id);
		return new ResponseJson(Constants.HTTP_OK_STATUS, accountService.findById(id));
	}

}
