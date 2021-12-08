package com.apps.ops.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apps.ops.model.Operation;

//@Repository
//public interface AccountRepository extends CrudRepository<Account, Integer>{
//	
//}

@Repository
public interface OperationRepository extends JpaRepository<Operation, BigDecimal>{
	
}