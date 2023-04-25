package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {
	
	@Test
	public void testContactConstructor() {
		// constructor with 
		//10 characters of ID, First Name, Last Name, and phone number 
		//and 30 characters of address
		Contact contact = new Contact("CS32004091", "LaJamesone", "DeFloyydit", "9173019987", "1 Main St, Brooklyn, NY, 11220");
		assertTrue(contact.getContactID().equals("CS32004091"));
		assertTrue(contact.getFirstName().equals("LaJamesone"));
		assertTrue(contact.getLastName().equals("DeFloyydit"));
		assertTrue(contact.getphoneNumber().equals("9173019987"));
		assertTrue(contact.getAddress().equals("1 Main St, Brooklyn, NY, 11220"));
		 
	}
	
	@Test
	public void testContact_WhenContactIDNullandTooLong()  {

		//ID in 11 digits
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "James", "Loyd", "9173019987", "1 Main St, Brooklyn, NY");
        });
        
        // ID is null
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null , "James", "Loyd", "9173019987", "1 Main St, Brooklyn, NY");
        });
	}
	
	@Test
	public void testContact_WhenFirstNameNullandTooLong()  {
		
		//First Name in 11 characters
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("9987654", "Jamabcdeees", "Loyd", "9173019987", "1 Main St, Brooklyn, NY");
        });
        
        // First Name is null
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	 new Contact("9987654", null , "Loyd", "9173019987", "1 Main St, Brooklyn, NY");
        });
	}
	
	@Test
	public void testContact_WhenLastNameNullandTooLong()  {
		
		//Last Name too long
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("9997654", "James", "Loyyyyyyyyyyyyyyyyyd", "9173019987", "1 Main St, Brooklyn, NY");
        });
        
        // Last Name is null
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact("9997654", "James", null , "9173019987", "1 Main St, Brooklyn, NY");
        });
	}
	
	@Test
	public void testContact_WhenPhoneNumNullandTooLong()  {
		
		//Phone Number in 11 digits
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("9999654", "James", "Loyd", "917301998765", "1 Main St, Brooklyn, NY");
        });
        
        // Phone Number  is null
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact("9999654", "James", "Loyd" , null, "1 Main St, Brooklyn, NY");
        });
	}

	@Test
	public void testContact_WhenAddressNullandTooLong()  {
		
		//Address in 31 digits
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("9999654", "James", "Loyd", "9173019987", "1 Main St, Brooklyn, Kings Coun");
        });
        
        // Phone Number  is null
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact("9999654", "James", "Loyd", "9173019987", null);
        });
	}
	
	@Test
	public void testSetters_WhenNullParameters() {
		Contact contact = new Contact();
		
		//test set first name to be null 
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);	});
	
		// test set last name to be null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName(null);});	
		
		// test set phone number to be null
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setphoneNumber(null);});
		
		// test set address to be null
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress(null);});
	}
	
	@Test
	public void testSetters_WhenParametersTooLong() {
		Contact contact = new Contact();
		
				//test set first name too long (in 11 characters)
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					contact.setFirstName("Jammemmmmes");	});
			
				// test set last name too long
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					contact.setLastName("Loyyyyyyyyy");});	
				
				// test set phone number too long(in 11 characters)
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					contact.setphoneNumber("12345678912");});
			
				// test set address too long (in 31 characters)
				
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					contact.setAddress("1 Main St, Brooklyn, Kings Coun");});
		
	}

	@Test
	public void testSetters_WhenGoodParameters() {
		//Given
		Contact contact = new Contact("CS32004091", "LaJamesone", "DeFloyydit", "9173019987", "1 Main St, Brooklyn, NY, 11220");
		
			
		//When
		contact.setFirstName("LeJamesone");
		contact.setLastName("DeFroyydit");
		contact.setphoneNumber("9173019988");
		contact.setAddress("1 Main St, Brooklyn, NY, 11221");
		
		
		//Then
		
		assertAll(
				()-> assertTrue(contact.getFirstName().equals("LeJamesone")), 
				()-> assertTrue(contact.getLastName().equals("DeFroyydit")), 
				()-> assertTrue(contact.getphoneNumber().equals("9173019988")), 
				()-> assertTrue(contact.getAddress().equals("1 Main St, Brooklyn, NY, 11221"))
		);
		
	}


}

