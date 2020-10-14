package com.capgemini;

import java.util.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
import java.text.ParseException;
import java.util.Calendar;

//UC4 - find cheapest hotel within a date range
public class HotelReservation {

	private ArrayList<Hotel> hotelList = new ArrayList<Hotel>();

	public boolean addHotel(Hotel newHotel) {
		hotelList.add(newHotel);
		return true;
	}

	// method to add a hotel

	public Hotel findCheapestHotel(Date start, Date end, long weekDays) {
		long noOfDays = 1 + (end.getTime() - start.getTime()) / (1000 * 60 * 60 * 24);
		long weekEnds = noOfDays - weekDays;
		System.out.println("Weekdays: " + weekDays + " Weekends: " + weekEnds);
		for (Hotel h : hotelList) {
			long totalCostOfStay = ((weekDays) * h.getRegularCustomerRateForWeekday())
					+ (weekEnds * h.getRegularCustomerRateForWeekend());
			h.setTotalRate(totalCostOfStay);

		}
		Hotel cheapestHotel = hotelList.stream().sorted(Comparator.comparing(Hotel::getTotalRate)).findFirst()
				.orElse(null);
		return cheapestHotel;
	}

	// method to find cheapest hotel with in a date range
	// Refactored to find cheapest hotels according to weekends and weekdays rates

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

			} while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); // excluding end date

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
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Hotel Reservation Program!");
		HotelReservation service = new HotelReservation();
		Hotel hotel1 = new Hotel("Lakewood", 110, 90, 3.0);
		Hotel hotel2 = new Hotel("Bridgewood", 150, 50, 4.0);
		Hotel hotel3 = new Hotel("Ridgewood", 220, 150, 5.0);
		service.addHotel(hotel1);
		service.addHotel(hotel2);
		service.addHotel(hotel3);
		while (true) {
			System.out.println(
					"\n1.Add a Hotel \n2.Find the cheapest Hotel \n3.Display the Hotel list \n4.Exit \nEnter your choice: ");
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
						System.out.println("Enter rating of the Hotel: ");
						double rating = Double.parseDouble(sc.nextLine());
						Hotel newHotel = new Hotel(name, ratesForWeekdays, ratesForWeekends, rating);
						service.addHotel(newHotel);
						System.out.println("Hotel " + name + " added to the Hotel Reservation System!\n");
					} else {

						break;
					}
				}
				break;
			case 2:
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
				Hotel found = service.findCheapestBestRatedHotel(startDate, endDate, weekDays);
				System.out.println(found);
				System.out.println("Total cost of stay: " + found.getTotalRate() + "$ .");
				break;

			case 3:
				System.out.println("\nThe Hotel list is as follows: ");
				service.printHotel();
				break;
			case 4:
				System.out.println("Thankyou for using the application!");
				System.exit(0);
				break;

			}

		}
	}
}
