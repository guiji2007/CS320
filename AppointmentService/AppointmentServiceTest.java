package appoint2;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {

	

	static Appointment appointment1 = new Appointment("0001", LocalDate.of(2023, 05,30), "0001 due date");
    static Appointment appointment2 = new Appointment("0002", LocalDate.of(2023, 06,30), "0002 due date");
    static Appointment appointment3 = new Appointment("0003", LocalDate.of(2023, 07,30), "0003 due date");

	

	@Test
	public void addAppointmentShouldThrowExceptionWhenExistingID() {
		// Given 
	
		String existingID = "0001"; 
		LocalDate appointDate = LocalDate.of(2023, 07, 30);
		String description = "New Appointment is Created!!!";
		AppointmentService.appointments.add(appointment1);
		AppointmentService.appointments.add(appointment2);
		AppointmentService.appointments.add(appointment3);

		//Then Throw exception when the task ID already exists
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			AppointmentService.addAppointment(existingID, appointDate, description);	
        });
		
	}

	@Test
	public void addAppointmentShouldReturnTrueWhenNewID() {
		//Given
        String newID = "0004"; 
        LocalDate appointDate = LocalDate.of(2023, 07, 30);
        String description = "New Appointment is Created!!!";
        AppointmentService.appointments.add(appointment1);
        AppointmentService.appointments.add(appointment2);
        AppointmentService.appointments.add(appointment3);

        //When

		Appointment newApp = AppointmentService.addAppointment(newID, appointDate, description);
   
        //Then
        assertAll(
			()->assertEquals(newApp.getAppointmentID(), newID),
			()->assertEquals(newApp.getAppointDate(), appointDate), 
			()->assertEquals(newApp.getDescription(), description)
		);
        
    }
	
	@Test
	public void deleteAppointmentShouldThrowErrorWhenIDNotExist() {
		//Given
		String deleteID = "0005";

		//Then Throw exception when the task ID does not exist
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AppointmentService.deleteAppointment(deleteID);
        });
		
		
		
		}
	
	
	@Test
	public void deleteAppointmentShouldReturnTrueWhenIDExist() {
		//Given
		String deleteID = "0001";
		Boolean appointmentIsDeleted = null;
		
		//When
		AppointmentService.deleteAppointment(deleteID);
		for (int i = 0; i<AppointmentService.appointments.size(); i++) {
				if (AppointmentService.appointments.get(i).getAppointmentID().equals(deleteID)) {
				 	appointmentIsDeleted = false;
				}
					else appointmentIsDeleted = true;
				 }
				
				assertTrue(appointmentIsDeleted);
		
		
		
		
	}
	
	
	
//}
}