
package com.capgemini;

public class Hotel {

	private String hotelName;
	private int regularCustomerRateForWeekday;
	private int regularCustomerRateForWeekend;
	private long totalRate = 0;
	private double rating;
	private int rewardCustomerRateForWeekday;
	private int rewardCustomerRateForWeekend;

	// parameterized constructor
	public Hotel(String hotelName, int regularCustomerRateForWeekday, int regularCustomerRateForWeekend,
			int rewardCustomerRateForWeekday, int rewardCustomerRateForWeekend, double rating) {
		this.hotelName = hotelName;
		this.regularCustomerRateForWeekday = regularCustomerRateForWeekday;
		this.regularCustomerRateForWeekend = regularCustomerRateForWeekend;
		// this.totalRate = 0;
		this.rating = rating;
		this.rewardCustomerRateForWeekday = rewardCustomerRateForWeekday;
		this.rewardCustomerRateForWeekend = rewardCustomerRateForWeekend;

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

	public int getRewardCustomerRateForWeekday() {
		return rewardCustomerRateForWeekday;
	}

	public void setRewardCustomerRateForWeekday(int rate) {
		this.rewardCustomerRateForWeekday = rate;
	}

	public int getRewardCustomerRateForWeekend() {
		return rewardCustomerRateForWeekend;
	}

	public void setRewardCustomerRateForWeekend(int rate) {
		this.rewardCustomerRateForWeekend = rate;
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
		return "\nHotel Name: " + hotelName + "\nRating: " + rating + " ";
	}
}
