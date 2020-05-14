package com.app.aforo255account.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.aforo255account.model.entity.Account;
import com.app.aforo255account.repository.AccountRepository;

@Service
public class AccountServiceImp implements IAccountService{
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Account> findAll() {
	
		return (List<Account>) accountRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Account findById(Integer id) {
		// TODO Auto-generated method stub
		return (Account) accountRepository.findById(id).orElse(null);
	}

	@Override
	public Account save(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}

}
