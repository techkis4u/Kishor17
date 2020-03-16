package com.cpd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cpd.command.ShipmentBookingCommand;
import com.cpd.deligate.DtdcBookingDeligate;
import com.cpd.repo.DtdcCustomerRepository;
import com.cpd.validator.ShipmentBookingValidator;

@Controller
public class ShipmentBookingController {

	
	@Autowired
	private ShipmentBookingValidator shipmentvalidator;
	
	@Autowired
	private DtdcBookingDeligate deligate;
	
	@RequestMapping("/shipment-booking")
	public String booking() {
		return "shipmentbooking";
	}
	
	@ModelAttribute("bookingCommand")
	public ShipmentBookingCommand emptyCommandObject() {
		
		return new ShipmentBookingCommand();
		
	}
	@PostMapping("/shipment-booking")
	public String doBooking(@ModelAttribute("bookingCommand")ShipmentBookingCommand bookingCommand,BindingResult errors) {
		if(shipmentvalidator.supports(ShipmentBookingCommand.class)) {
			shipmentvalidator.validate(bookingCommand, errors);
			
			if(errors.hasErrors()) {
				
				return "shipmentbooking";
			}
		}
		
		System.out.println(bookingCommand);
		deligate.doDtdcBooking(bookingCommand);
		return "registration-success";
		
	}
	
	
}
