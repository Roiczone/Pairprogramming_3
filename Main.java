import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Admin admin = new Admin("admin", "admin123");

        HashMap<String, CitizenUser> citizenUsers = new HashMap<>();

        while(true) {
            System.out.println("\n--- City Hall System ---");
            System.out.println("1. Admin Login");
            System.out.println("2. Citizen Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1 -> adminMenu(admin, citizenUsers, sc);
                case 2 -> citizenMenu(citizenUsers, sc);
                case 3 -> { System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void adminMenu(Admin admin, HashMap<String, CitizenUser> users, Scanner sc) {
        System.out.print("Enter Admin username: ");
        String uname = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();
        if(!admin.getUsername().equals(uname) || !admin.checkPassword(pass)) {
            System.out.println("Invalid credentials.");
            return;
        }

        while(true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Register Citizen");
            System.out.println("2. Update Citizen");
            System.out.println("3. Remove Citizen");
            System.out.println("4. View All Citizens");
            System.out.println("5. Add Appointment Type");
            System.out.println("6. Remove Appointment Type");
            System.out.println("7. View Appointment Types");
            System.out.println("8. Logout");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1 -> {
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Address: "); String addr = sc.nextLine();
                    System.out.print("Gender: "); String gender = sc.nextLine();
                    System.out.print("Religion: "); String religion = sc.nextLine();
                    admin.registerCitizen(name, age, addr, gender, religion);

                    Citizen c = admin.getCitizens().get(admin.getCitizens().size());
                    users.put(name.toLowerCase(), new CitizenUser(name.toLowerCase(), "pass123", c));
                }
                case 2 -> {
                    System.out.print("Citizen ID to update: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("New Name: "); String name = sc.nextLine();
                    System.out.print("New Age: "); int age = sc.nextInt(); sc.nextLine();
                    System.out.print("New Address: "); String addr = sc.nextLine();
                    System.out.print("New Gender: "); String gender = sc.nextLine();
                    System.out.print("New Religion: "); String religion = sc.nextLine();
                    admin.updateCitizen(id, name, age, addr, gender, religion);
                }
                case 3 -> { System.out.print("Citizen ID to remove: "); int id = sc.nextInt(); sc.nextLine(); admin.removeCitizen(id); }
                case 4 -> admin.viewAllCitizens();
                case 5 -> {
                    System.out.print("Appointment type name: "); String typeName = sc.nextLine();
                    System.out.print("Enter available dates (comma separated): "); String datesStr = sc.nextLine();
                    List<String> dates = Arrays.asList(datesStr.split(","));
                    admin.addAppointmentType(typeName, dates);
                }
                case 6 -> { System.out.print("Appointment type name to remove: "); String t = sc.nextLine(); admin.removeAppointmentType(t); }
                case 7 -> admin.viewAppointmentTypes();
                case 8 -> { System.out.println("Logging out..."); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void citizenMenu(HashMap<String, CitizenUser> users, Scanner sc) {
        System.out.print("Enter username: ");
        String uname = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        if(!users.containsKey(uname) || !users.get(uname).checkPassword(pass)) {
            System.out.println("Invalid credentials.");
            return;
        }

        CitizenUser citizenUser = users.get(uname);

        while(true) {
            System.out.println("\n--- Citizen Menu ---");
            System.out.println("1. Book Appointment");
            System.out.println("2. Cancel Appointment");
            System.out.println("3. View Appointments");
            System.out.println("4. Logout");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1 -> {
                    List<AppointmentType> types = new ArrayList<>();
                    for(CitizenUser u : users.values()) { types.addAll(u.getCitizen().getId() == citizenUser.getCitizen().getId() ? new ArrayList<>() : new ArrayList<>()); }
                    if(types.isEmpty()) { System.out.println("No appointment types available."); break; }
                    System.out.print("Enter appointment type name: "); String typeName = sc.nextLine();
                    System.out.print("Enter appointment date: "); String date = sc.nextLine();
                    citizenUser.bookAppointment(new AppointmentType(typeName, new ArrayList<>(List.of(date))), date);
                }
                case 2 -> { citizenUser.viewAppointments(); System.out.print("Enter appointment index to cancel: "); int idx = sc.nextInt(); sc.nextLine(); citizenUser.cancelAppointment(idx); }
                case 3 -> citizenUser.viewAppointments();
                case 4 -> { System.out.println("Logging out..."); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
