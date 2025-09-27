import java.util.*;

public class Admin extends User {
    private HashMap<Integer, Citizen> citizens;
    private HashMap<String, AppointmentType> appointmentTypes;
    private int nextCitizenId = 1;

    public Admin(String username, String password) {
        super(username, password);
        citizens = new HashMap<>();
        appointmentTypes = new HashMap<>();
    }


    public void registerCitizen(String name, int age, String address, String gender, String religion) {
        Citizen c = new Citizen(nextCitizenId++, name, age, address, gender, religion);
        citizens.put(c.getId(), c);
        System.out.println("Citizen registered successfully: " + c);
    }

    public void updateCitizen(int id, String name, int age, String address, String gender, String religion) {
        if(citizens.containsKey(id)) {
            Citizen c = citizens.get(id);
            c.setName(name);
            c.setAge(age);
            c.setAddress(address);
            c.setGender(gender);
            c.setReligion(religion);
            System.out.println("Citizen updated: " + c);
        } else {
            System.out.println("Citizen not found.");
        }
    }

    public void removeCitizen(int id) {
        if(citizens.containsKey(id)) {
            citizens.remove(id);
            System.out.println("Citizen removed.");
        } else {
            System.out.println("Citizen not found.");
        }
    }

    public void viewAllCitizens() {
        if(citizens.isEmpty()) {
            System.out.println("No citizens registered.");
            return;
        }
        for(Citizen c : citizens.values()) {
            System.out.println(c);
        }
    }


    public void addAppointmentType(String typeName, List<String> availableDates) {
        AppointmentType type = new AppointmentType(typeName, availableDates);
        appointmentTypes.put(typeName, type);
        System.out.println("Appointment type added: " + typeName);
    }

    public void removeAppointmentType(String typeName) {
        if(appointmentTypes.containsKey(typeName)) {
            appointmentTypes.remove(typeName);
            System.out.println("Appointment type removed: " + typeName);
        } else {
            System.out.println("Appointment type not found.");
        }
    }

    public void viewAppointmentTypes() {
        if(appointmentTypes.isEmpty()) {
            System.out.println("No appointment types available.");
            return;
        }
        for(AppointmentType a : appointmentTypes.values()) {
            System.out.println(a);
        }
    }


    public HashMap<Integer, Citizen> getCitizens() { return citizens; }
    public HashMap<String, AppointmentType> getAppointmentTypes() { return appointmentTypes; }
}