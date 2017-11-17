package com.src.ReadAddressBook.AddressBook;

import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SearchUsersInFile {

	public long findNoOFMales(String filePath) {
		ReadInputFile readFIle = new ReadInputFile();
		List<User>  users = readFIle.readUserFromFile(filePath);
		return users.stream().filter(u ->u.getUserGender().equals(Gender.MALE)).count();
	}

	public User findOldestPerson(String filePath) {
		ReadInputFile readFIle = new ReadInputFile();
		List<User>  users = readFIle.readUserFromFile(filePath);
		return Collections.min(users, Comparator.comparing(u -> u.getDateOfBirth()));
	}

	public long findDaysBetweenUsers(String filePath, String userName1, String userName2) {
		ReadInputFile readFIle = new ReadInputFile();
		List<User>  users = readFIle.readUserFromFile(filePath);
		User user1 = users.stream().filter(u ->u.getUserName().contains(userName1)).findFirst().orElse(null);
		User user2 = users.stream().filter(u ->u.getUserName().contains(userName2)).findFirst().orElse(null);
		
		return ChronoUnit.DAYS.between(user1.getDateOfBirth(), user2.getDateOfBirth());
	}
}
