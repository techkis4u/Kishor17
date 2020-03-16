package com.cpd.repo;

import org.springframework.data.repository.CrudRepository;

import com.cpd.model.ShipingAddress;

public interface ShipingAddressRepository extends CrudRepository<ShipingAddress,Integer > {

}
