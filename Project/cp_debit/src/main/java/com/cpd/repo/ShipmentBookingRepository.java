package com.cpd.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cpd.model.ShipmentBooking;

@Repository
public interface ShipmentBookingRepository extends CrudRepository<ShipmentBooking, String> {
	
	@Query(value="SELECT PRICE FROM DTDC_SERVICE s WHERE s.SOURCE =:source and s.DESTNATION=:destnation",nativeQuery = true)
	public Integer findPrice(@Param("source")String source,@Param("destnation") String destnation);
	
	
	
}