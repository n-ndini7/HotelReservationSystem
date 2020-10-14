
package com.capgemini;

public class Hotel {

	private String hotelName;
	private int regularCustomerRateForWeekday;
	private int regularCustomerRateForWeekend;
	private long totalRate;

	// parameterized constructor
	public Hotel(String hotelName, int regularCustomerRateForWeekday, int regularCustomerRateForWeekend) {
		this.hotelName = hotelName;
		this.regularCustomerRateForWeekday = regularCustomerRateForWeekday;
		this.regularCustomerRateForWeekend = regularCustomerRateForWeekend;
		this.totalRate = 0;
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

	@Override
	public String toString() {
		return "\nHotel Name: " + hotelName
				+ "\nHotel rates for a regular customer (per day): \n For Weekdays(Mon-Fri) : "
				+ regularCustomerRateForWeekday + "$ \n For Weekends(Sat-Sun): " + regularCustomerRateForWeekend
				+ "$ ";
	}
}
