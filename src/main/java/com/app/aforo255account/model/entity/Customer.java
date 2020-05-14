package com.app.aforo255account.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_customer")
	private Integer IdCustomer;
	@Column(name="fullname")
	private String Fullname;
	public Integer getIdCustomer() {
		return IdCustomer;
	}
	public void setIdCustomer(Integer idCustomer) {
		IdCustomer = idCustomer;
	}
	public String getFullname() {
		return Fullname;
	}
	public void setFullname(String fullname) {
		Fullname = fullname;
	}
	

}
