package appoint2;

import java.time.LocalDate;

public class Appointment {
	private String appointmentID;
	private LocalDate appointDate;
	private String description;



	public Appointment(String appointmentID, LocalDate appointDate, String description) {
		if (appointmentID == null || appointmentID.length() > 10){
			throw new IllegalArgumentException("Invald Input");
		} else if(appointDate == null) {
			throw new IllegalArgumentException("Invad Appointment Date");
		} else if(appointDate.isBefore(LocalDate.now())){
			throw new IllegalArgumentException("Invad Appointment Date");
		} else if(description == null || description.length() > 50){
            throw new IllegalArgumentException("Invald Appointment Description");
		}
			this.appointmentID = appointmentID;
			this.appointDate = appointDate;
			this.description = description;
	}

	public String getAppointmentID() { return this.appointmentID;}

	public LocalDate getAppointDate() {return this.appointDate;}

	public void setAppointDate(LocalDate appointDate) {
		if (appointDate == null || appointDate.isBefore(LocalDate.now())) {
			throw new IllegalArgumentException("Invad Appointment Date");
		}
		this.appointDate = appointDate;
	}

	public String getDescription() {	return this.description;}

	public  void setDescription(String description) {
		if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invald Appointment Descriptionription");
        }
		this.description = description;
	}

}

