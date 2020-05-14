package com.app.aforo255account.service;

import java.util.List;

import com.app.aforo255account.model.entity.Account;

public interface IAccountService {
	public List<Account> findAll();
	public Account findById(Integer id);
	public Account save(Account account);
}
