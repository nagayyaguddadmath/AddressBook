package com.src.ReadAddressBook.AddressBook;

import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * User model for user details
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userName;
	private Gender userGender;
	private LocalDate dateOfBirth;

	//convert String to LocalDate with minus of 100 years for taking 19.. instead of 20..
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");

	public User() {
	};

	public User(String userLine) throws ParseException {
		String[] arr = userLine.split(", ");
		this.userName = arr[0];
		this.userGender = Gender.getByGenderName(arr[1]);
		//This should be improved if we need to consider 20.. DOB also
		this.dateOfBirth = LocalDate.parse(arr[2], formatter).minusYears(100);
	}

	public String getUserName() {
		return userName;
	}

	public Gender getUserGender() {
		return userGender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	@Override
	public String toString() {
		return "userName:" + userName + ", userGender: " + userGender.getGender() + ", dateOfBirth: " + dateOfBirth.format(formatter);
	}
}
