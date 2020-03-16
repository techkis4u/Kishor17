package com.cpd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpd.model.DtdcCustomer;
import com.cpd.repo.DtdcCustomerRepository;

@Service
public class DtdcCustomerService {

	@Autowired
	private DtdcCustomerRepository dtdcCustomerRepository;
	
	public DtdcCustomer saveCustomer(DtdcCustomer customer) {
		
		return dtdcCustomerRepository.save(customer);
	}
	
}
