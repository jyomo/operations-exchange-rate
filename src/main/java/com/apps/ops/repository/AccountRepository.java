package com.apps.ops.repository;

import org.springframework.stereotype.Repository;

import com.apps.ops.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
//public interface AccountRepository extends CrudRepository<Account, Integer>{
//	
//}

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
}