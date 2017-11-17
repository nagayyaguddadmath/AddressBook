package com.src.ReadAddressBook.AddressBook;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private Gender userGender;
	private Date dateOfBirth;

	public User() {
	};

	public User(String userLine) throws ParseException {
		String[] arr = userLine.split(", ");
		this.userName = arr[0];
		this.userGender = Gender.getByGenderName(arr[1]);
		this.dateOfBirth = new SimpleDateFormat("dd/MM/yy").parse(arr[2]);  
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "userName:" + userName + ", userGender: " + userGender.getGender() + ", dateOfBirth: " + dateOfBirth.toString();
	}
}
