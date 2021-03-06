package com.cpd.deligate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cpd.command.RegistrationCommand;
import com.cpd.model.Address;
import com.cpd.model.Login;
import com.cpd.model.User;
import com.cpd.service.AddressService;
import com.cpd.service.LoginService;
import com.cpd.service.UserService;

@Component
public class DtdcRegistrationDeligate {
	@Autowired
	private UserService userService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private LoginService loginService;

	public boolean register(RegistrationCommand command) {
		User user = extractUserFromCommand(command);
		Address address = extractAddressFromCommand(command);
		Login login = extractLoginFromCommand(command);

		User saveuser = userService.saveUser(user);

		login.setUser(user);
		loginService.saveLogin(login);

		System.out.println(saveuser);

		address.setUser(saveuser);
		addressService.saveAddress(address);

		return true;
	}

	private User extractUserFromCommand(RegistrationCommand command) {
		User user = new User();
		user.setName(command.getName());
		user.setPhone(command.getPhone());
		user.setEmail(command.getEmail());
		user.setDob(command.getDob());
		System.out.println(user);
		return user;

	}

	private Address extractAddressFromCommand(RegistrationCommand command) {
		Address address = new Address();

		address.setAddressLine1(command.getAddressLine1());
		address.setAddressLine2(command.getAddressLine2());
		address.setCity(command.getCity());
		address.setState(command.getState());
		address.setCountry(command.getCountry());
		address.setZip(command.getZip());
		return address;
	}
	
	private Login extractLoginFromCommand(RegistrationCommand command) {

		Login login = new Login();
		login.setUserName(command.getUserName());
		login.setPassword(command.getPassword());
		login.setRole("USER");
		login.setUserType(command.getUserType());

		return login;
	}
}
