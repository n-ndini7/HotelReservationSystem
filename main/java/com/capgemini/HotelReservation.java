package com.capgemini;

import java.util.*;
import java.util.ArrayList;

//UC1 - add hotel
public class HotelReservation {

	private ArrayList<Hotel> hotelList = new ArrayList<Hotel>();

	public boolean addHotel(Hotel newHotel) {
		hotelList.add(newHotel);
		return true;
	}

	public static void main(String[] args) {
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

	}
}
