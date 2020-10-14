package com.capgemini;

import org.junit.Assert;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class HotelReservationTest {

	@Test
	public void HotelAdded_methodShouldReturnTrue() {
		HotelReservation service = new HotelReservation();
		Hotel hotelCheck = new Hotel("Bridgewood", 150, 50, 4.0);
		boolean checkIfAdded = service.addHotel(hotelCheck);
		Assert.assertEquals(checkIfAdded, true);
	}

	// test for add a hotel

	@Test
	public void testForcheapestHotelWithinADateRange_AccoringToWeekdayCharges() {
		HotelReservation service = new HotelReservation();
		Hotel hotel1 = new Hotel("Lakewood", 110, 90, 3.0);
		Hotel hotel2 = new Hotel("Bridgewood", 150, 50, 4.0);
		Hotel hotel3 = new Hotel("Ridgewood", 220, 150, 5.0);
		service.addHotel(hotel1);
		service.addHotel(hotel2);
		service.addHotel(hotel3);
		Date start = null;
		Date end = null;
		try {
			start = new SimpleDateFormat("ddMMMyyyy").parse("11Sep2020");
			end = new SimpleDateFormat("ddMMMyyyy").parse("12Sep2020");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		long weekDays = service.countWeekDays(start, end);
		Hotel found = service.findCheapestHotel(start, end, weekDays);
		Assert.assertEquals("Lakewood", found.getHotelName());
	}

	// test for finding cheapest hotel
}
