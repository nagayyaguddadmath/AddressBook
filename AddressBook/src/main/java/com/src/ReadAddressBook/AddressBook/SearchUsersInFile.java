package com.src.ReadAddressBook.AddressBook;

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

}
