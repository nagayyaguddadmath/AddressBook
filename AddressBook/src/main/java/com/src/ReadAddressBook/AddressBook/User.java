package com.src.ReadAddressBook.AddressBook;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements Serializable {

	private String userName;
	private Gender userGender;
	private Date dateOfBirth;

	public User() {
	};

	User(String userName, String gender, String dob) throws ParseException {
		this.userName = userName;
		this.userGender = Gender.getByGenderName(gender);
		this.dateOfBirth = new SimpleDateFormat("dd/MM/yy").parse(dob);  
	}
}
