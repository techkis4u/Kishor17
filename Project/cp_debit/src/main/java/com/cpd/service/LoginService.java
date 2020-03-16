package com.cpd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpd.command.LoginCommand;
import com.cpd.exception.UserNotFoundException;
import com.cpd.model.Login;
import com.cpd.repo.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository repository;

	public Login saveLogin(Login login) {

		return repository.save(login);
	}

	public Integer validateLogin(LoginCommand command) {

		Integer userId = repository.getLoginCount(command.getUserName(), command.getPassword(), command.getUserType());

		System.out.println(" isPresent : " + userId);

		if (userId == null) {

			throw new UserNotFoundException("Please Enter Valid User name/Password");
		}

		return userId;
	}
}
