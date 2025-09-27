import java.util.*;

public class AppointmentType {
    private String name;
    private List<String> availableDates;

    public AppointmentType(String name, List<String> availableDates) {
        this.name = name;
        this.availableDates = new ArrayList<>(availableDates);
    }

    public String getName() { return name; }
    public List<String> getAvailableDates() { return availableDates; }

    @Override
    public String toString() {
        return "Type: " + name + " | Available Dates: " + availableDates;
    }
}