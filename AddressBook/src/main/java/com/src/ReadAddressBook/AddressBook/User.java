package com.src.ReadAddressBook.AddressBook;

import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private Gender userGender;
	private LocalDate dateOfBirth;

	public User() {
	};

	public User(String userLine) throws ParseException {
		String[] arr = userLine.split(", ");
		this.userName = arr[0];
		this.userGender = Gender.getByGenderName(arr[1]);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
		//convert String to LocalDate
		this.dateOfBirth = LocalDate.parse(arr[2], formatter).minusYears(100);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Gender getUserGender() {
		return userGender;
	}

	public void setUserGender(Gender userGender) {
		this.userGender = userGender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "userName:" + userName + ", userGender: " + userGender.getGender() + ", dateOfBirth: " + dateOfBirth.toString();
	}
}
