package appoint2;
import java.time.LocalDate;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AppointmentTest {
	
	
    
    @Test 
    void TestAppointment_WhenNullID_LongID(){
     
    	//Test for null appointment id in Appointment Constructor
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, LocalDate.of(2023,  12, 31), "Appointment Description"));
        //Test for long appointment id in Appointment Constructor
        assertThrows(IllegalArgumentException.class, () -> new Appointment("APPID00000001", LocalDate.of(2023,  12, 31), "Appointment Description"));
    }
    
    @Test 
    void TestAppointment_WhenAppDateBeforeTodayorNullDate(){
    
    	//Test for null appointment id in Appointment Constructor
        assertThrows(IllegalArgumentException.class, () -> new Appointment("APPID001", LocalDate.of(2022,  12, 31), "Appointment Description"));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("APPID001", null, "Appointment Description"));
    }
    
    @Test 
    void TestAppointment_WhenNullDescription_LongDescription(){
    
    	//Test for null appointment id in Appointment Constructor
        assertThrows(IllegalArgumentException.class, () -> new Appointment("APPID001", LocalDate.of(2023,  12, 31), null));
        //Test for long appointment id in Appointment Constructor
        assertThrows(IllegalArgumentException.class, () -> new Appointment("APPID001", LocalDate.of(2023,  12, 31), "Appointment12312312313 Description123123123123123123132"));
    }
    
    
    
    
    @Test
    void TestAllSetterMethods() {
    	//Given
    	LocalDate date1 = LocalDate.of(2023, 12, 31);
    	LocalDate newFutureDate = LocalDate.of(2024, 12, 31);
    	LocalDate pastDate = LocalDate.of(2022, 12, 31);
    	Appointment app1 = new Appointment ("APPID001",date1, "Appointment 001");
    	
    	
    	
    	//When
    	app1.setAppointDate(newFutureDate);
    	app1.setDescription("Appointment 002");
    	
    	
 
    	//Then Test for Getter methods for proper appointment date and appointment description
    	assertTrue(newFutureDate == app1.getAppointDate());
    	assertTrue(app1.getDescription()== "Appointment 002");
    	assertTrue(app1.getAppointmentID()== "APPID001");
    	
    	
    	
    		//Test for Setter Methods for null Date and Date before today.
    	 assertThrows(IllegalArgumentException.class, () -> app1.setAppointDate(null));
    	 assertThrows(IllegalArgumentException.class, () -> app1.setAppointDate(pastDate));
    	 	
    }
    
    @Test
    void TestSetDescritionWhenNullandLongDescrition() {
    	
    	//Given
    	Appointment app1 = new Appointment ("APPID001",LocalDate.of(2023, 12, 31), "Appointment 001");
    	
    	//Then
    	assertThrows(IllegalArgumentException.class, () -> app1.setDescription(null));
    	assertThrows(IllegalArgumentException.class, () -> app1.setDescription("Appointment12312312313 Description123123123123123123132"));
    	
    	
    	
    }
   
    
    
    
}