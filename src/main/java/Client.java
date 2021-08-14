import java.util.ArrayList;
import java.util.List;

public class Client {
    //Attributes
    private String name;
    private String address;
    private String phone;
    private String cep;
    private String email;

    private List<Animal> animals;

    //Constructor
    public Client(String name, String address, String phone, String cep, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.cep = cep;
        this.email = email;
        this.animals = new ArrayList<Animal>();
    }

    //Getters
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

    //Setters
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

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    @Override
    public String toString() {
        return "Cliente {\n\tNome: " + name + "\n\tEndereço: " + address + "\n\tTelefone: " + phone + "\n\tCEP: " + cep + "\n\tEmail: " + email + "\n}";
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}