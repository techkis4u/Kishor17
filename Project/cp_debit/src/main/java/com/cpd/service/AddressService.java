package com.cpd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpd.model.Address;
import com.cpd.repo.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	public Address saveAddress(Address address) {
		
		return addressRepository.save(address);
	}
}
