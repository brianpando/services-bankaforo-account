package com.app.aforo255account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.aforo255account.model.entity.Account;
import com.app.aforo255account.service.IAccountService;

@RestController
public class AccountController {
	@Autowired
	private IAccountService service;
	
	@GetMapping("listar")
	public List<Account> listar() {
		return service.findAll();
	}
	
	@GetMapping("ver/{id}")
	public Account detalle( @PathVariable Integer id) {
		return service.findById(id);
	}

}
