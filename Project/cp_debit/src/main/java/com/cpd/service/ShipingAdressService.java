package com.cpd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpd.model.ShipingAddress;
import com.cpd.repo.ShipingAddressRepository;

@Service
public class ShipingAdressService {

	@Autowired
	private ShipingAddressRepository  addressRepository;

	public ShipingAddress saveShingAddress(ShipingAddress address) {
		
		
		return addressRepository.save(address);
		
	}
}
