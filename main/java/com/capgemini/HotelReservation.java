package com.capgemini;

import java.util.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.stream.Collectors;
import java.text.ParseException;
import java.util.Calendar;

//UC12 - find cheapest best rated hotel for a regular customer and exceptions added for invalid customer type
public class HotelReservation {

	private ArrayList<Hotel> hotelList = new ArrayList<Hotel>();

	public boolean addHotel(Hotel newHotel) {
		hotelList.add(newHotel);
		return true;
	}

	// method to add a hotel
	public Hotel findCheapestBestRatedHotel(Date start, Date end, long weekDays, Customer customer) {
		long noOfDays = 1 + (end.getTime() - start.getTime()) / (1000 * 60 * 60 * 24);
		long weekEnds = noOfDays - weekDays;
		System.out.println("Weekdays: " + weekDays + " Weekends: " + weekEnds);
		if (customer.getCustomerType().equalsIgnoreCase("Regular")) {
			for (Hotel hotel : hotelList) {
				long totalRate = weekDays * hotel.getRegularCustomerRateForWeekday()
						+ weekEnds * hotel.getRegularCustomerRateForWeekend();
				hotel.setTotalRate(totalRate);
			}
		} else if (customer.getCustomerType().equalsIgnoreCase("Reward")) {
			for (Hotel hotel : hotelList) {
				long totalRate = weekDays * hotel.getRewardCustomerRateForWeekday()
						+ weekEnds * hotel.getRewardCustomerRateForWeekend();
				hotel.setTotalRate(totalRate);
			}
		}
		List<Hotel> listOfBestRatedHotels = hotelList.stream().sorted(Comparator.comparing(Hotel::getTotalRate))
				.collect(Collectors.toList());

		Hotel cheapestHotel = listOfBestRatedHotels.get(0);
		long cheapestHotelRate = listOfBestRatedHotels.get(0).getTotalRate();
		for (Hotel hotel : listOfBestRatedHotels) {
			if (hotel.getTotalRate() <= cheapestHotelRate) {
				if (hotel.getRating() > cheapestHotel.getRating())
					cheapestHotel = hotel;
			} else
				break;
		}

		return cheapestHotel;
	}

	// method to find cheapest hotel with in a date range
	// Refactored to find cheapest hotels according to weekends and weekdays rates
	// Refactored to find cheapest hotel according to rating
	// find the cheapest best rated hotel for a reward customer

	public Hotel findBestRatedHotel(Date start, Date end, long weekDays, Customer customer) {
		long noOfDays = 1 + (end.getTime() - start.getTime()) / (1000 * 60 * 60 * 24);
		long weekEnds = noOfDays - weekDays;
		System.out.println("Weekdays: " + weekDays + " Weekends: " + weekEnds);
		if (customer.getCustomerType().equalsIgnoreCase("Regular")) {
			for (Hotel hotel : hotelList) {
				long totalRate = weekDays * hotel.getRegularCustomerRateForWeekday()
						+ weekEnds * hotel.getRegularCustomerRateForWeekend();
				hotel.setTotalRate(totalRate);
			}
		} else if (customer.getCustomerType().equalsIgnoreCase("Reward")) {
			for (Hotel hotel : hotelList) {
				long totalRate = weekDays * hotel.getRewardCustomerRateForWeekday()
						+ weekEnds * hotel.getRewardCustomerRateForWeekday();
				hotel.setTotalRate(totalRate);
			}
		}

		List<Hotel> listOfBestRatedHotels = hotelList.stream().sorted(Comparator.comparing(Hotel::getRating).reversed())
				.collect(Collectors.toList());
		Hotel bestRatedHotel = listOfBestRatedHotels.get(0);
		for (Hotel hotel : listOfBestRatedHotels) {
			if (hotel.getTotalRate() <= bestRatedHotel.getTotalRate()) {
				if (hotel.getRating() > bestRatedHotel.getRating())
					bestRatedHotel = hotel;
			} else
				break;
		}

		return bestRatedHotel;
	}

	// find best rated hotel

	public long countWeekDays(Date start, Date end) {
		long countWeekdays = 0;
		long countWeekends = 0;
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(start);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(end);
		if (startCal.getTimeInMillis() < endCal.getTimeInMillis()) {

			do {

				if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
						&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
					++countWeekdays;
				}
				startCal.add(Calendar.DAY_OF_MONTH, 1);
			} while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());
		}
		return countWeekdays;
	}

	// counts number of weekdays between two date ranges
	public void printHotel() {
		for (Hotel h : hotelList) {
			System.out.println(h);
		}
	}

	// method to print the hotel list
	public static void main(String[] args) throws Exception {
		Date startDate = null;
		Date endDate = null;
		Customer customer = new Customer();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Hotel Reservation Program!");
		HotelReservation service = new HotelReservation();
		Hotel hotel1 = new Hotel("Lakewood", 110, 90, 80, 80, 3.0);
		Hotel hotel2 = new Hotel("Bridgewood", 150, 50, 110, 50, 4.0);
		Hotel hotel3 = new Hotel("Ridgewood", 220, 150, 100, 40, 5.0);
		service.addHotel(hotel1);
		service.addHotel(hotel2);
		service.addHotel(hotel3);
		while (true) {
			System.out.println("\n1.Add a Hotel \n2.Enter the customer type  \n5.Exit \nEnter your choice: ");
			int option = Integer.parseInt(sc.nextLine());
			switch (option) {
			case 1:
				while (true) {
					System.out.println("Do you wish to add a new Hotel to the System?(y/n)");
					String choice = sc.nextLine();
					if (choice.equalsIgnoreCase("y")) {
						System.out.println("Enter the Name of the Hotel: ");
						String name = sc.nextLine();
						System.out
								.println("Enter the rates of the Hotel for a Regular Customer for Weekdays(Mon-Sat): ");
						int ratesForWeekdays = Integer.parseInt(sc.nextLine());
						System.out.println("Enter the rates of the Hotel for a Regular Customer for Weekends(Sun): ");
						int ratesForWeekends = Integer.parseInt(sc.nextLine());
						System.out
								.println("Enter the rates of the Hotel for a Reward Customer for Weekdays(Mon-Sat): ");
						int ratesForWeekdaysforRewardCust = Integer.parseInt(sc.nextLine());
						System.out.println("Enter the rates of the Hotel for a Reward Customer for Weekends(Sun): ");
						int ratesForWeekendsForRewardCust = Integer.parseInt(sc.nextLine());
						System.out.println("Enter rating of the Hotel: ");
						double rating = Double.parseDouble(sc.nextLine());
						Hotel newHotel = new Hotel(name, ratesForWeekdays, ratesForWeekends,
								ratesForWeekdaysforRewardCust, ratesForWeekendsForRewardCust, rating);
						service.addHotel(newHotel);
						System.out.println("Hotel " + name + " added to the Hotel Reservation System!\n");
					} else {

						break;
					}
				}
				break;
			case 2:
				System.out.println("1.Press '1' for Regular Customers \n2.Press '2' for Reward Customers");
				int type = Integer.parseInt(sc.nextLine());
				try {
					if (type == 1) {
						customer.setCustomerType("Regular");
					} else if (type == 2) {
						customer.setCustomerType("Reward");
					} else
						throw new InvalidCustomerException();
				} catch (InvalidCustomerException e) {
					System.out.println(e.getMessage());
					break;
				}
				System.out.println(
						"1.Find the cheapest best rated Hotel \n2.Find the best rated hotel \n3.Display the Hotel List");
				int select = Integer.parseInt(sc.nextLine());
				if (select == 1) {
					try {
						System.out.println("Enter start date of the stay :");
						String start = sc.nextLine();
						startDate = new SimpleDateFormat("ddMMMyyyy").parse(start);
						System.out.println("Enter end date of the stay:");
						String end = sc.nextLine();
						endDate = new SimpleDateFormat("ddMMMyyyy").parse(end);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					long weekDays = service.countWeekDays(startDate, endDate);
					Hotel found = service.findCheapestBestRatedHotel(startDate, endDate, weekDays, customer);
					System.out.println(found);
					System.out.println("Total cost of stay: " + found.getTotalRate() + "$ .");
				} else if (select == 3) {
					System.out.println("\nThe Hotel list is as follows: ");
					service.printHotel();
				} else if (select == 2) {
					try {
						System.out.println("Enter start date of the stay :");
						String start = sc.nextLine();
						startDate = new SimpleDateFormat("ddMMMyyyy").parse(start);
						System.out.println("Enter end date of the stay:");
						String end = sc.nextLine();
						endDate = new SimpleDateFormat("ddMMMyyyy").parse(end);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					long weekDay = service.countWeekDays(startDate, endDate);
					Hotel hotel = service.findBestRatedHotel(startDate, endDate, weekDay, customer);
					System.out.println(hotel);
					System.out.println("Total cost of stay: " + hotel.getTotalRate() + "$ .");
				} else {
					System.out.println("Wrong choice entered!!");
				}
				break;
			case 5:
				System.out.println("Thankyou for using the application!");
				System.exit(0);
				break;

			}

		}
	}
}