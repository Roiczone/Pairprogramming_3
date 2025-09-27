import java.util.*;

public class CitizenUser extends User {
    private Citizen citizen;
    private List<Appointment> bookedAppointments;

    public CitizenUser(String username, String password, Citizen citizen) {
        super(username, password);
        this.citizen = citizen;
        bookedAppointments = new ArrayList<>();
    }

    public void bookAppointment(AppointmentType type, String date) {
        if(type.getAvailableDates().contains(date)) {
            Appointment a = new Appointment(type, date);
            bookedAppointments.add(a);
            type.getAvailableDates().remove(date);
            System.out.println("Appointment booked: " + a);
        } else {
            System.out.println("Selected date is not available.");
        }
    }

    public void cancelAppointment(int index) {
        if(index >= 0 && index < bookedAppointments.size()) {
            Appointment a = bookedAppointments.remove(index);
            a.getType().getAvailableDates().add(a.getDate());
            System.out.println("Appointment canceled: " + a);
        } else {
            System.out.println("Invalid appointment selection.");
        }
    }

    public void viewAppointments() {
        if(bookedAppointments.isEmpty()) {
            System.out.println("No appointments booked.");
            return;
        }
        for(int i = 0; i < bookedAppointments.size(); i++) {
            System.out.println(i + ". " + bookedAppointments.get(i));
        }
    }

    public Citizen getCitizen() { return citizen; }
}
