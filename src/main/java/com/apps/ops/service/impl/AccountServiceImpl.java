package com.apps.ops.service.impl;

import java.util.List;
import java.util.Optional;

import com.apps.ops.model.Account;
import com.apps.ops.repository.AccountRepository;
import com.apps.ops.service.AccountService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	private static final Logger logger = LogManager.getLogger(AccountServiceImpl.class);

	@Autowired

	private AccountRepository accountRepository;

	@Override
	public List<Account> list() {
		logger.info("listando data...");
		List<Account> data = accountRepository.findAll();
		logger.info("Ctd Registros obtenidos: {}", data.size());
		return data;
	}

	@Override
	public void registerAccount(Account account) {
		logger.info("Registrando data...");
		accountRepository.save(account);
		logger.info("Registro exitoso.");
	}

	@Override
	public Optional<Account> findById(Integer id) {
		logger.info("listando data...");
		Optional<Account> data = accountRepository.findById(id);
		logger.info(data.isPresent() ? data : null);
		return data;
	}

}
