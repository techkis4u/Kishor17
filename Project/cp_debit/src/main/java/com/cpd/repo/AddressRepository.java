package com.cpd.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cpd.model.Address;

@Repository
public interface AddressRepository  extends CrudRepository<Address, Integer>{

}
