package com.src.ReadAddressBook.AddressBook;

import java.io.IOException;
import java.text.ParseException;

/*
 * Main class to run this application
 * Main method can take parameter for input file 
 */
public class Application {


	private static String inputfilePath = Application.class.getResource("resources/address-book.txt").getFile();

	public static void main(String[] args) throws IOException, ParseException {

		//argument can have path of the file that needs to be processed
		SearchUsersInFile fileUsers = new SearchUsersInFile(args.length == 0 ? inputfilePath : args[0]);

		findNoOfMales(fileUsers);

		findOldestPerson(fileUsers);

		findDaysBetweenUsers(fileUsers, "Bill", "Paul");
		System.exit(0);
	}

	/*
	 * Finds no of males present in given file
	 */
	public static void findNoOfMales(SearchUsersInFile searchUsers) throws IOException, ParseException {
		long noOfUsersFound = searchUsers.findNoOFMales();
		System.out.println("No Of males Found in the given file is: " + noOfUsersFound);
	}

	/*
	 * Finds oldest person present in given file
	 */
	public static void findOldestPerson(SearchUsersInFile searchUsers) throws IOException, ParseException {
		User oldestUser = searchUsers.findOldestPerson();
		System.out.println("Oldest user in the given file is: " + oldestUser.getUserName());
	}

	/*
	 * Finds Days between two users
	 */
	public static void findDaysBetweenUsers(SearchUsersInFile searchUsers, String userName1, String userName2) throws IOException, ParseException {
		long daysDiff = searchUsers.findDaysBetweenUsers(userName1, userName2);
		System.out.println("Bill is older than Paul by " + daysDiff + " days");
	}

}
