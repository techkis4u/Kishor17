package com.cpd.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpd.service.ShipmentBookingService;

@RestController
public class BookingPriceController {

	@Autowired
	private ShipmentBookingService bookingService;
	
	@PostMapping("/api/find-price")
	public ResponseEntity<?> getBookingPrice(@RequestBody BookingPriceSearchCriteria bookingPriceSearchCriteria) {

		Integer price = bookingService.getPriceBySourceAndDestination(bookingPriceSearchCriteria.getSource(),
				bookingPriceSearchCriteria.getDestination());
		System.out.println("price:" + price);
		BookingPriceReponse bookingPriceReponse = new BookingPriceReponse();
		bookingPriceReponse.setPrice(price);

		return ResponseEntity.ok(bookingPriceReponse);
	}
}
