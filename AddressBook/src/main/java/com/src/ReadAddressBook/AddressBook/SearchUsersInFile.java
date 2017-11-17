package com.src.ReadAddressBook.AddressBook;

import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SearchUsersInFile {
	
	private List<User> users;
	
	public SearchUsersInFile(String filePath) {
		ReadInputFile readFIle = new ReadInputFile();
		users = readFIle.readUserFromFile(filePath);
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
