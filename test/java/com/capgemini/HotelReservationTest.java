package com.capgemini;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

	@Test
	public void HotelAdded_methodShouldReturnTrue() {
		HotelReservation service = new HotelReservation();
		Hotel hotelCheck = new Hotel("Bridgewood", 160);
		boolean checkIfAdded = service.addHotel(hotelCheck);
		Assert.assertEquals(checkIfAdded, true);
	}

	// test for add a hotel

}
