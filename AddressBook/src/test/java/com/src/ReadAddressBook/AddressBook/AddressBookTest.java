package com.src.ReadAddressBook.AddressBook;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AddressBookTest 
extends TestCase
{
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AddressBookTest( String testName )
	{
		super( testName );
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite( AddressBookTest.class );
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testNoOfMales()
	{
		String strPathOfInputFile = System.getProperty("user.dir") + 
				"\\src\\test\\resources\\" + "address-book.txt";

		SearchUsersInFile searchUsers = new SearchUsersInFile();
		long noOfUsersFound = searchUsers.findNoOFMales(strPathOfInputFile);
		assertEquals("no of males did not match", 3, noOfUsersFound);
	}

	public void testOldestPerson()
	{
		String strPathOfInputFile = System.getProperty("user.dir") + 
				"\\src\\test\\resources\\" + "address-book.txt";

		SearchUsersInFile searchUsers = new SearchUsersInFile();
		User oldestUser = searchUsers.findOldestPerson(strPathOfInputFile);
		assertEquals("Oldest user did not match", "Wes Jackson", oldestUser.getUserName());
	}

}
