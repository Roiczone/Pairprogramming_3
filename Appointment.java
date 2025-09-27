public class Appointment {
    private AppointmentType type;
    private String date;

    public Appointment(AppointmentType type, String date) {
        this.type = type;
        this.date = date;
    }

    public AppointmentType getType() { return type; }
    public String getDate() { return date; }

    @Override
    public String toString() {
        return type.getName() + " on " + date;
    }
}