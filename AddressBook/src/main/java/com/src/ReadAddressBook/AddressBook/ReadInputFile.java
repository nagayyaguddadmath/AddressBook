package com.src.ReadAddressBook.AddressBook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadInputFile {

	public List<User> readUserFromFile(String filename) {
		List<User> Users = new ArrayList<User>();
		String line;
		try (
				BufferedReader br = new BufferedReader(new FileReader(filename))
				) {

			while( (line = br.readLine()) != null){
				Users.add(new User(line));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} 

		return Users;
	}

}
