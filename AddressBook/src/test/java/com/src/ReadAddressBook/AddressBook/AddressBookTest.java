package com.src.ReadAddressBook.AddressBook;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for AddressBook App.
 */
public class AddressBookTest extends TestCase
{
	public AddressBookTest( String testName )
	{
		super( testName );
	}

	public static Test suite()
	{
		return new TestSuite( AddressBookTest.class );
	}

	private String strPathOfInputFile = System.getProperty("user.dir") + 
			"\\src\\test\\resources\\" + "address-book.txt";

	/**
	 * Rigourous Test :-)
	 */
	public void testNoOfMales()
	{
		SearchUsersInFile searchUsers = new SearchUsersInFile(strPathOfInputFile);
		long noOfUsersFound = searchUsers.findNoOFMales();
		assertEquals("no of males did not match", 3, noOfUsersFound);
	}

	public void testOldestPerson()
	{
		SearchUsersInFile searchUsers = new SearchUsersInFile(strPathOfInputFile);
		User oldestUser = searchUsers.findOldestPerson();
		assertEquals("Oldest user did not match", "Wes Jackson", oldestUser.getUserName());
	}

	public void testDaysBetweenUsers()
	{
		SearchUsersInFile searchUsers = new SearchUsersInFile(strPathOfInputFile);
		long daysDiff = searchUsers.findDaysBetweenUsers("Bill", "Paul");
		assertEquals("Oldest user did not match", 2862, daysDiff);
	}

}
