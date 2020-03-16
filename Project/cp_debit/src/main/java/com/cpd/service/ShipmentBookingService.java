package com.cpd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpd.model.ShipmentBooking;
import com.cpd.repo.ShipmentBookingRepository;

@Service
public class ShipmentBookingService {

	@Autowired
	private ShipmentBookingRepository shipmentBookingRepository;

	public ShipmentBooking doBookingShipment(ShipmentBooking booking) {
		ShipmentBooking shipmentBooking = shipmentBookingRepository.save(booking);
		return shipmentBooking;
	}

	public Integer getPriceBySourceAndDestination(String source, String destination) {

		return shipmentBookingRepository.findPrice(source, destination);

	}

}
