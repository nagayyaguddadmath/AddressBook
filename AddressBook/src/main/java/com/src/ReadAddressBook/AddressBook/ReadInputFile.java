package com.src.ReadAddressBook.AddressBook;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadInputFile {

	public List<User> readUserFromFile(String filename) {
		List<User> Users = new ArrayList<User>();
		User user = null;
		try (
				FileInputStream fin = new FileInputStream(filename);
				ObjectInputStream ois = new ObjectInputStream(fin)
				) {

			while( (user = (User) ois.readObject()) != null){
				Users.add(user);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} 

		return Users;
	}

}
