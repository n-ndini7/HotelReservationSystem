package com.capgemini;

import org.junit.Assert;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.util.ArrayList;

public class HotelReservationTest {

	@Test
	public void HotelAdded_methodShouldReturnTrue() {
		HotelReservation service = new HotelReservation();
		Hotel hotelCheck = new Hotel("Bridgewood", 150, 50, 110, 50, 4.0);
		boolean checkIfAdded = service.addHotel(hotelCheck);
		Assert.assertEquals(checkIfAdded, true);
	}

	// test for add a hotel

	@Test
	public void testForcheapestHotelWithinADateRange_AccoringToWeekdayCharges() {
		HotelReservation service = new HotelReservation();
		Hotel hotel1 = new Hotel("Lakewood", 110, 90, 80, 80, 3.0);
		Hotel hotel2 = new Hotel("Bridgewood", 150, 50, 110, 50, 4.0);
		Hotel hotel3 = new Hotel("Ridgewood", 220, 150, 100, 40, 5.0);
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
		Customer customer = new Customer();
		customer.setCustomerType("Regular");
		Hotel hotel = service.findCheapestBestRatedHotel(start, end, weekDays, customer);
		Assert.assertEquals("Bridgewood", hotel.getHotelName());
	}

	// test for cheapest hotel
	// test to get cheapest hotel for reward type customer
	// test to get best rated cheapest hotel for reward type customer

	@Test
	public void testForBestHotelWithinADateRange_AccordingToRating() {
		HotelReservation service = new HotelReservation();
		Hotel hotel1 = new Hotel("Lakewood", 110, 90, 80, 80, 3.0);
		Hotel hotel2 = new Hotel("Bridgewood", 150, 50, 110, 0, 4.0);
		Hotel hotel3 = new Hotel("Ridgewood", 220, 150, 100, 40, 5.0);
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
		Customer customer = new Customer();
		customer.setCustomerType("Regular");
		Hotel hotel = service.findBestRatedHotel(start, end, weekDays, customer);
		Assert.assertEquals("Ridgewood", hotel.getHotelName());
	}

	// find best rated hotel
	// find best hotel for reward type customers
}
