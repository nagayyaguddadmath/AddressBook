package com.src.ReadAddressBook.AddressBook;

public enum Gender {
	MALE("Male"),
	FEMALE("Female");
	
	private String gender;
	
	private Gender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}
	
	public static Gender getByGenderName(String genderName) {
		for (Gender gender: values()) {
			if (gender.getGender().equals(genderName)) {
				return gender;
			}
		}
		return null;
	}
}
