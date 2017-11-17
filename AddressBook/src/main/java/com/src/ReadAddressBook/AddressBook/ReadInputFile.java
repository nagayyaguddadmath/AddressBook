package com.src.ReadAddressBook.AddressBook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Reads Given file and returns the user list
 */
public class ReadInputFile {

	public List<User> readUserFromFile(String filePath) throws IOException, ParseException {
		List<User> Users = new ArrayList<User>();
		File file = new File(filePath);
		try (
				Scanner scanner = new Scanner(file)
				) {

			while(scanner.hasNextLine()){
				Users.add(new User(scanner.nextLine()));
			}

		} catch (ParseException ex) {
			System.out.println(ex.getMessage());
			throw ex;
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
			throw ex;
			
		} 

		return Users;
	}

}
