package appoint2;

import java.time.LocalDate;
import java.util.ArrayList;



class AppointmentService {

    static ArrayList<Appointment> appointments = new ArrayList<Appointment>();
    

    public static Appointment addAppointment(String appointmentID, LocalDate appointDate, String description){
        if (appointments.stream().anyMatch(Appointment -> Appointment.getAppointmentID().equals(appointmentID))){
        	 throw new IllegalArgumentException("ID already exists");
        }
        Appointment appointment = new Appointment(appointmentID, appointDate, description);
        appointments.add(appointment);   
        System.out.println("The appointment has been added!");
        return appointment;
    }
    
    
    public static void deleteAppointment(String appointmentID){
        if (appointments.stream().anyMatch(Appointment -> Appointment.getAppointmentID().equals(appointmentID))){
            appointments.removeIf(Appointment -> Appointment.getAppointmentID().equals(appointmentID));
            System.out.println("The appointment has been deleted!");
        }else{
            throw new IllegalArgumentException("ID does not exist");
        }
    }
}  