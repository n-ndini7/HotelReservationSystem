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

//UC9 - entry of rates for reward customers as a part of loyalty program
public class HotelReservation {

	private ArrayList<Hotel> hotelList = new ArrayList<Hotel>();

	public boolean addHotel(Hotel newHotel) {
		hotelList.add(newHotel);
		return true;
	}

	// method to add a hotel

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
				System.out.println("1.For Regular Customers \n2.For Reward Customers");
				int type = Integer.parseInt(sc.nextLine());
				if (type == 1) {
					customer.setCustomerType("Regular");
				} else if (type == 2) {
					customer.setCustomerType("Reward");
				}
				System.out.println("3.Display the Hotel List");
				int select = Integer.parseInt(sc.nextLine());
				if (select == 3) {
					System.out.println("\nThe Hotel list is as follows: ");
					service.printHotel();
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
