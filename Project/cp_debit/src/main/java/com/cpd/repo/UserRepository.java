package com.cpd.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cpd.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
