package contact;

public class Contact {
	String contactID;
	String firstName;
	String lastName;
	String phoneNumber;
	String address;
	
	
	public Contact( String contactID, String firstName, String lastName, String phoneNumber, String address) {
		 
		if(contactID == null || firstName == null || lastName == null ||phoneNumber == null || address == null
				||(contactID.length()>10|| firstName.length()>10|| lastName.length()>10 || phoneNumber.length()>10 || address.length()>30)){
			
			throw new IllegalArgumentException("INVALID INPUT");
		}
	
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;

	}
		
		
	
	
	public Contact() {
		
	}

	public String getContactID() {
		return this.contactID;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length()>10 ) {
			throw new IllegalArgumentException("INVALID INPUT");
		}

		this.firstName = firstName;
		
	}
		
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null ||lastName.length()>10) {
			throw new IllegalArgumentException("INVALID INPUT");
		}

		this.lastName = lastName;
	}
	
	public String getphoneNumber() {
		return this.phoneNumber;
	}

	public void setphoneNumber(String phoneNumber) {
		if ( phoneNumber == null ||phoneNumber.length()>10) {
			throw new IllegalArgumentException("INVALID INPUT");
		}

		this.phoneNumber = phoneNumber;	
	}
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		if (address == null || address.length()>30 ) {
			throw new IllegalArgumentException("INVALID INPUT");
		}

		this.address = address;
	}

	
}
