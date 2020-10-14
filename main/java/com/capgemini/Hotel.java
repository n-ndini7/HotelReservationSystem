
package com.capgemini;

public class Hotel {

	private String hotelName;
	private int regularCustomerRateForWeekday;
	private int regularCustomerRateForWeekend;
	private long totalRate;
	private double rating;

	// parameterized constructor
	public Hotel(String hotelName, int regularCustomerRateForWeekday, int regularCustomerRateForWeekend,
			double rating) {
		this.hotelName = hotelName;
		this.regularCustomerRateForWeekday = regularCustomerRateForWeekday;
		this.regularCustomerRateForWeekend = regularCustomerRateForWeekend;
		this.totalRate = 0;
		this.rating = rating;
	}

	// getters and setters
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRegularCustomerRateForWeekday() {
		return regularCustomerRateForWeekday;
	}

	public void setRegularCustomerRateForWeekday(int rate) {
		this.regularCustomerRateForWeekday = rate;
	}

	public int getRegularCustomerRateForWeekend() {
		return regularCustomerRateForWeekend;
	}

	public void setRegularCustomerRateForWeekend(int rate) {
		this.regularCustomerRateForWeekend = rate;
	}

	public long getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(long rate) {
		this.totalRate = rate;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "\nHotel Name: " + hotelName
				+ "\nHotel rates for a regular customer (per day): \nFor Weekdays(Mon-Sat) : "
				+ regularCustomerRateForWeekday + "$ \nFor Weekends(Sun): " + regularCustomerRateForWeekend
				+ "$ \nRating: " + rating + "/5.0 ";
	}
}
