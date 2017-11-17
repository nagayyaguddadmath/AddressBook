package com.src.ReadAddressBook.AddressBook;

import java.io.IOException;
import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Has methods to search users
 */
public class SearchUsersInFile {
	
	private List<User> users;

	ReadInputFile readFIle = new ReadInputFile();
	
	//Can inject the file path to constructor
	public SearchUsersInFile(String filePath) throws IOException, ParseException {
		users = readFIle.readUserFromFile(filePath);
		if (users.isEmpty()) {
			System.out.println("No Users Found in the file");
		}
	}

	public long findNoOFMales() {
		return users.stream().filter(u ->u.getUserGender().equals(Gender.MALE)).count();
	}

	public User findOldestPerson() {
		return Collections.min(users, Comparator.comparing(u -> u.getDateOfBirth()));
	}

	public long findDaysBetweenUsers(String userName1, String userName2) {
		User user1 = users.stream().filter(u ->u.getUserName().contains(userName1)).findFirst().orElse(null);
		User user2 = users.stream().filter(u ->u.getUserName().contains(userName2)).findFirst().orElse(null);
		
		return ChronoUnit.DAYS.between(user1.getDateOfBirth(), user2.getDateOfBirth());
	}
}
