import java.util.ArrayList;
import java.util.List;

public class Client {
    //Attributes
    private int ID;
    private String name;
    private String address;
    private String phone;
    private String cep;
    private String email;

    private List<Animal> animals;

    //Constructor
    public Client(int ID, String name, String address, String phone, String cep, String email) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.cep = cep;
        this.email = email;
        this.animals = new ArrayList<Animal>();
    }

    //Getters
    public int getID() { return ID; }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }

    public String getEmail() {
        return email;
    }

    public List<Animal> getAnimals() {
        return new ArrayList<Animal>(animals);
    }

    //Setters
    public void setID(int ID) { this.ID = ID; }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addAnimal(ArrayList<Animal> animal) {
        this.animals = animal;
    }

    @Override
    public String toString() {
        return "Cliente [\n\tID: " + ID + "\n\tNome: " + name + "\n\tEndereço: " + address + "\n\tTelefone: " + phone + "\n\tCEP: " + cep + "\n\tEmail: " + email + "\n\tAnimals: " + getAnimals().toString() + "\n]";
    }

}