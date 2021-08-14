public class Animal {
    //Attributes
    private int id;
    private String name;
    private int age;
    private int gender; // 0: Male; 1: Female

    //Constructor
    public Animal(int id, String name, int age, int gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public int getGender() {
        return gender;
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

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Animal {\n\tID: " + id + "\n\tNome: " + name + "\n\tIdade: " + age + "\n\tGênero: " + gender + "\n}";
    }
}