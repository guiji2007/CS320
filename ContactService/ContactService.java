package contact;

import java.util.ArrayList;
import java.util.Arrays;


public class ContactService {

	static Contact contact1 = new Contact("001", "Ivan", "Greens", "1234567890", "123 Main St, Westborough, MA");
	static Contact contact2 = new Contact("002", "Lily", "Williams", "4567890123", "456 Broadway, Westborough, MA");
	static Contact contact3 = new Contact("003", "Jim", "Evans", "7890123456", "789 7th AV, Westborough, MA");
	static ArrayList <Contact> contacts = new ArrayList<>(Arrays.asList(contact1, contact2, contact3));
	
	 
	 
	 //check if the contact is unique or not
	 public static boolean contactIDisUnique (String contactID){
	        //loop over the contact list, if one of the contact object has the ID, return false; else, return true.
	        for (Contact eachContact:contacts) {
	        	if(eachContact.getContactID().equals(contactID)) {
	        		return false;
	        	}
	        }
			return true; 
	    }
	 public static Contact locateContact (String contactID) {
		 for (Contact eachContact:contacts) {
	        	if(eachContact.getContactID().equals(contactID)) {
	        		return eachContact;
	        	}
		 }
		return null;
	 }

	 public static int addContact(Contact contact){
		if (contactIDisUnique(contact.getContactID())) {
			contacts.add(contact);
			System.out.println("The contact has been added!");
			return 1;
		} else {
			
			return 0;
		}
	 }
	 
	 public static int deleteContact(String contactID) {
		 if (!contactIDisUnique(contactID)) {
			 Contact contactToDelete = locateContact(contactID);
			 contacts.remove(contactToDelete);
			 System.out.println("The contact has been deleted!");
			 return 1;
		 }else {
			 return 0;
		 }
	 }
			 
			 
			 
			
	 
	 
	 
	 public static int updateContact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
		 if (!contactIDisUnique(contactID)) {
			 Contact contactToUpdate = locateContact(contactID);
			 contactToUpdate.setFirstName(firstName);
			 contactToUpdate.setLastName(lastName);
			 contactToUpdate.setphoneNumber(phoneNumber);
			 contactToUpdate.setAddress(address);
			 System.out.println("The contact has been updated!");
			 return 1;
		 }
		 return 0;
	 }
	 







}
