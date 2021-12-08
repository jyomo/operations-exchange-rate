package com.apps.ops.service;

import java.util.Optional;

import com.apps.ops.model.Account;
import com.apps.ops.model.CoreExchange;
import com.apps.ops.model.MovementChange;

public interface CoreExchangeService {

	public CoreExchange getExchangeData(Optional<Account> sourceAccount, Optional<Account> targetAccount,
			MovementChange movement);

}
