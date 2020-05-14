package com.app.aforo255account.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.aforo255account.model.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

}
