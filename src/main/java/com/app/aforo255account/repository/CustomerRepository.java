package com.app.aforo255account.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.app.aforo255account.model.entity.Customer;

@Repository
public interface CustomerRepository  extends CrudRepository<Customer, Integer> {

}
