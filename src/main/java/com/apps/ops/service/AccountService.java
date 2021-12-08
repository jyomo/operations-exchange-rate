package com.apps.ops.service;

import java.util.List;
import java.util.Optional;

import com.apps.ops.model.Account;

public interface AccountService {
	public List<Account> list();

	public Optional<Account> findById(Integer id);

	public void registerAccount(Account account);
}
