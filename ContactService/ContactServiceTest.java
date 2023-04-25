package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ContactServiceTest {
	
	@ParameterizedTest
	@CsvSource(value ="000")
	void should_ReturnTrue_When_NewContactID(String contactID) {
		
		// GIVEN
		Boolean expected = true;
		
		//When
		Boolean actual = ContactService.contactIDisUnique(contactID);
		
		//Then 
		
		assertEquals(expected, actual);
		
	}
	
	@ParameterizedTest
	@CsvSource(value ="001")
	void should_LocateContact_When_CorrectContactID(String contactID) {
		
		
		// Given
		Contact expected = ContactService.contact1;
		
		//When
		Contact actual = ContactService.locateContact(contactID);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void should_AddContact_When_NewContactID() {
		//Given
		Contact contactTest = new Contact("004", "Gray", "Bills", "1357924680", "321 Green St, Westborough, MA");
		int expected = 1;
		//When
		int actual = ContactService.addContact(contactTest);
		
		//Then
		assertEquals(expected, actual);
	}
	
	
	@ParameterizedTest
	@CsvSource(value ="003")
	void should_DeleteContact_When_CorrectContactID(String contactID){
		//Given
		int expected = 1;
		
		//When
		int actual = ContactService.deleteContact(contactID);
		
		//Then
		assertEquals(expected, actual);
		
	}



	@ParameterizedTest
	@CsvSource(value ="002")
	void should_UpdateContact_When_CorrectContactID(String contactID) {
		
		//Given
		int expected = 1;
		
		//When
		int actual = ContactService.updateContact("002", "Brian", "Jackon", "1234445555", "789 Broadway, Westborough, MA");
	
		//Then
		assertEquals(expected, actual);
		
	}












}
