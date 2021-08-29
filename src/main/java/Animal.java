public class Animal {
    //Attributes
    private int id;
    private String name;
    private int age;
    private String gender;
    private int clientId;

    //Constructor
    public Animal(int id, String name, int age, String gender, int clientId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.clientId = clientId;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public int getClientId() {
        return clientId;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "\n\t\tID: " + id + "\n\t\tNome: " + name + "\n\t\tIdade: " + age + "\n\t\tGênero: " + gender + "\n\t";
    }
}