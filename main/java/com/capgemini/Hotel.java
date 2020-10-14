
package com.capgemini;

public class Hotel {

	private String hotelName;
	private int regularCustomerRate;
	private long totalRate;

	// parameterized constructor
	public Hotel(String hotelName, int regularCustomerRate) {
		this.hotelName = hotelName;
		this.regularCustomerRate = regularCustomerRate;
		this.totalRate = 0;
	}

	// getters and setters
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRegularCustomerRate() {
		return regularCustomerRate;
	}

	public void setRegularCustomerRate(int rate) {
		this.regularCustomerRate = rate;
	}

	public long getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(long rate) {
		this.totalRate = rate;
	}

	@Override
	public String toString() {
		return "\nHotel Name: " + hotelName + "\nHotel rates for a regular customer (per day): " + regularCustomerRate
				+ "$\nTotal Cost of Stay: " + totalRate + "$ .";
	}
}
