package com.cpd.deligate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cpd.command.ShipmentBookingCommand;
import com.cpd.model.DtdcCustomer;
import com.cpd.model.ShipingAddress;
import com.cpd.model.ShipmentBooking;
import com.cpd.model.User;
import com.cpd.service.DtdcCustomerService;
import com.cpd.service.ShipingAdressService;
import com.cpd.service.ShipmentBookingService;
import com.cpd.service.UserService;

@Component
public class DtdcBookingDeligate {

	@Autowired
	private UserService service;
	@Autowired
	private ShipmentBookingService bookingService;
	
	@Autowired
	private ShipingAdressService addressService;
	
	
	@Autowired
	private DtdcCustomerService dtdcCustomerService;

	public boolean doDtdcBooking(ShipmentBookingCommand bookingCommand){
		
		DtdcCustomer customer=extractDtdcCustomerFromShipmentBookingCommand(bookingCommand);
		DtdcCustomer dtdcCustomer=dtdcCustomerService.saveCustomer(customer);
		
		ShipingAddress address=extractShipingAddressFromShingAddressCommand(bookingCommand);
		address.setCustomer(dtdcCustomer);
		
		ShipingAddress shipingAddress=addressService.saveShingAddress(address);
		
		ShipmentBooking booking=extractShipmentBookingFromShipmentBookingCommand(bookingCommand);
		
		User user=service.getUserById(bookingCommand.getUserId());
		
		booking.setUser(user);
		booking.setDtdcCustomer(dtdcCustomer);
	
		
		ShipmentBooking shipmentBooking=bookingService.doBookingShipment(booking);
		
		
		
		return true;
	}
	public DtdcCustomer extractDtdcCustomerFromShipmentBookingCommand(ShipmentBookingCommand bookingCommand) {
		
		DtdcCustomer  customer=new DtdcCustomer();
		customer.setName(bookingCommand.getName());
		customer.setPhone(bookingCommand.getPhone());
		customer.setEmail(bookingCommand.getEmail());
		
		return customer;
	
	}
	
	public ShipmentBooking extractShipmentBookingFromShipmentBookingCommand(ShipmentBookingCommand bookingCommand) {
		
		ShipmentBooking booking=new ShipmentBooking();
		
		booking.setBookingDateTime(bookingCommand.getDob());
		booking.setBookingParcelType(bookingCommand.getBookingParcelType());
		booking.setBookingPrice(bookingCommand.getPrice());
		booking.setDestination(bookingCommand.getDestination());
		booking.setSource(bookingCommand.getSource());
		booking.setQuantity(bookingCommand.getQuantity());
		booking.setVasProdCod(bookingCommand.getVasProdCod());
		booking.setItemWeight(bookingCommand.getWeight());
		
		return booking;
	}
	
	public ShipingAddress extractShipingAddressFromShingAddressCommand(ShipmentBookingCommand bookingCommand) {
		
		ShipingAddress address=new ShipingAddress();
		
		address.setFromAddressLine1(bookingCommand.getFromAddressLine1());
		address.setFromAddressLine2(bookingCommand.getFromAddressLine2());
		address.setFromCity(bookingCommand.getFromCity());
		address.setFromCountry(bookingCommand.getFromCountry());
		address.setFromState(bookingCommand.getFromState());
		address.setFromZip(bookingCommand.getFromZip());
		
		address.setToAddressLine1(bookingCommand.getToAddressLine1());
		address.setToAddressLine2(bookingCommand.getToAddressLine2());
		address.setToCity(bookingCommand.getToCity());
		address.setToCountry(bookingCommand.getToCountry());
		address.setToState(bookingCommand.getToState());
		address.setToZip(bookingCommand.getToZip());
		
		address.setType(bookingCommand.getType());
		return address;
		
	}
}
