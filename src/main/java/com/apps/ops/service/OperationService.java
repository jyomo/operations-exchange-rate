package com.apps.ops.service;

import java.util.List;
import java.util.Optional;

import com.apps.ops.model.Account;
import com.apps.ops.model.MovementChange;
import com.apps.ops.model.Operation;
import com.apps.ops.util.ResponseJson;

public interface OperationService {

	public List<Operation> list();

	public void save(Operation operation);

	public ResponseJson transfer(Optional<Account> sourceAccount, Optional<Account> targetAccount,
			MovementChange movementChange);
}
