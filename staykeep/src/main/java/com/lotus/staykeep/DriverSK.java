package com.lotus.staykeep;

import java.util.Scanner;

public class DriverSK {

	public static void main(String[] args) {
		menu();
		
	}
	
	public static void menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Lotus Hotel. Would you lik to make a reservation? (Y/N)");
		String userInput = scan.next();
		switch(userInput) {
		case "Y":
		case "y":
			System.out.println("Awesome! Let's get you logged in.");
			login();
			break;
		case "N":
		case "n":
			System.out.println("OK...");
		case"Q":
		case"q":
			System.out.println("Goodbye.");
			System.exit(0);
			break;
		default: 
			System.out.println("Please pick Y/y for yes, N/n for No, or Q/q to quit");
			menu();
		}
	}
	
	public static void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter username");
		String userName = scan.next();
		System.out.println("Please enter password");
		String passWord = scan.next();
//Send to an auth
// login if no problems occur
		makeReserv();
	}
	
	public static void makeReserv() {
		//Ask how many days
		//get a display of all available rooms
		//pick a room to see date/times that room is available
		//pick a room
		//set that room, occupied for that period of time?
	}

}
