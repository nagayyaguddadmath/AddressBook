package com.src.ReadAddressBook.AddressBook;

import java.io.IOException;
import java.text.ParseException;
import java.time.format.DateTimeParseException;

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
	private String strPathOfWrongFile = System.getProperty("user.dir") + 
			"\\src\\test\\resources\\" + "address-book-wrong.txt";

	/**
	 * Rigourous Test :-)
	 * @throws ParseException 
	 * @throws IOException 
	 */
	public void testNoOfMales() throws IOException, ParseException
	{
		SearchUsersInFile searchUsers = new SearchUsersInFile(strPathOfInputFile);
		long noOfUsersFound = searchUsers.findNoOFMales();
		assertEquals("no of males did not match", 3, noOfUsersFound);
	}

	public void testOldestPerson() throws IOException, ParseException
	{
		SearchUsersInFile searchUsers = new SearchUsersInFile(strPathOfInputFile);
		User oldestUser = searchUsers.findOldestPerson();
		assertEquals("Oldest user did not match", "Wes Jackson", oldestUser.getUserName());
	}

	public void testDaysBetweenUsers() throws IOException, ParseException
	{
		SearchUsersInFile searchUsers = new SearchUsersInFile(strPathOfInputFile);
		long daysDiff = searchUsers.findDaysBetweenUsers("Bill", "Paul");
		assertEquals("Oldest user did not match", 2862, daysDiff);
	}

	public void testWrongFilePath()
	{
		try {
			SearchUsersInFile searchUsers = new SearchUsersInFile(strPathOfInputFile + ".txt");
			long daysDiff = searchUsers.findDaysBetweenUsers("Bill", "Paul");
			assertEquals("Oldest user did not match", 2862, daysDiff);
		} catch( IOException ex) {
			assertTrue("Exception should occur", true);
		} catch (ParseException e) {
			assertTrue("This Exception should not occur", false);
		}
	}

	public void testWrongFileContent()
	{
		try {
			SearchUsersInFile searchUsers = new SearchUsersInFile(strPathOfWrongFile);
			long daysDiff = searchUsers.findDaysBetweenUsers("Bill", "Paul");
			assertEquals("Oldest user did not match", 2862, daysDiff);
		} catch( DateTimeParseException ex) {
			assertTrue("This Exception should occur", true);
		} catch (ParseException e) {
			assertTrue("This Exception should not occur", false);
		} catch (IOException e) {
			assertTrue("This Exception should not occur", false);
		}
	}


}
