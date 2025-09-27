public class Citizen {
    private int id;
    private String name;
    private int age;
    private String address;
    private String gender;
    private String religion;

    public Citizen(int id, String name, int age, String address, String gender, String religion) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.religion = religion;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getAddress() { return address; }
    public String getGender() { return gender; }
    public String getReligion() { return religion; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setAddress(String address) { this.address = address; }
    public void setGender(String gender) { this.gender = gender; }
    public void setReligion(String religion) { this.religion = religion; }

    @Override
    public String toString() {
        return id + ". " + name + " | Age: " + age + " | Address: " + address + " | Gender: " + gender + " | Religion: " + religion;
    }
}