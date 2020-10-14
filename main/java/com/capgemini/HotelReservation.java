package com.capgemini;

import java.util.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

//UC2 - find the cheapest hotel within a date range
public class HotelReservation {

	private ArrayList<Hotel> hotelList = new ArrayList<Hotel>();

	public boolean addHotel(Hotel newHotel) {
		hotelList.add(newHotel);
		return true;
	}

	// method to add a hotel

	public Hotel findCheapestHotel(Date start, Date end) {
		long noOfDays = (1 + (end.getTime() - start.getTime())) / (1000 * 60 * 60 * 24);
		Hotel cheapestHotel = hotelList.stream().sorted(Comparator.comparing(Hotel::getRegularCustomerRate)).findFirst()
				.orElse(null);
		long totalCostOfStay = noOfDays * cheapestHotel.getRegularCustomerRate();
		cheapestHotel.setTotalRate(totalCostOfStay);
		return cheapestHotel;

	}

	// method to find cheapest hotel with in a date range

	public static void main(String[] args) throws Exception {
		Date startDate = null;
		Date endDate = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Hotel Reservation Program!");
		HotelReservation service = new HotelReservation();
		Hotel hotel1 = new Hotel("Lakewood", 110);
		Hotel hotel2 = new Hotel("Bridgewood", 160);
		Hotel hotel3 = new Hotel("Ridgewood", 220);
		service.addHotel(hotel1);
		service.addHotel(hotel2);
		service.addHotel(hotel3);
		while (true) {
			System.out.println("\n1.Add a Hotel \n2.Find the cheapest Hotel \n3.Exit \nEnter your choice: ");
			int option = Integer.parseInt(sc.nextLine());
			switch (option) {
			case 1:
				while (true) {
					System.out.println("Do you wish to add a new Hotel to the System?(y/n)");
					String choice = sc.nextLine();
					if (choice.equalsIgnoreCase("y")) {
						System.out.println("Enter the Name of the Hotel: ");
						String name = sc.nextLine();
						System.out.println("Enter the rates of the Hotel for a Regular Customer: ");
						int rates = Integer.parseInt(sc.nextLine());
						Hotel newHotel = new Hotel(name, rates);
						service.addHotel(newHotel);
						System.out.println("Hotel " + name + " added to the Hotel Reservation System!\n");
					} else {
						System.out.println("Thankyou!");
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

				Hotel found = service.findCheapestHotel(startDate, endDate);
				System.out.println(found);
				break;

			case 3:
				System.out.println("Thankyou for using the application!");
				System.exit(0);
				break;

			}

		}
	}
}
