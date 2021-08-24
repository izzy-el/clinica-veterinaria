import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Client client = new Client(1, "Izael", "Rua de Prudente", "18", "19000000", "j175037");
        Animal animal = new Animal(1, "Anonymous", 3, "Male", client.getID());
//        cliente.addAnimal(animal);
//        System.out.println(cliente.toString());
//        System.out.println(animal.toString());

//        ClientDAO clientDAO;
//        AnimalDAO animalDAO;
//        clientDAO = ClientDAO.getInstance();
//        animalDAO = AnimalDAO.getInstance();
//        clientDAO.create(client.getName(), client.getAddress(), client.getPhone(), client.getCep(), client.getEmail());
//        animalDAO.create(animal.getName(), animal.getAge(), animal.getGender(), client);

//        clientDAO.create("Izael", "Rua de Prudente", "18", "19000000", "j175037");
//        clientDAO.delete(2);
    }
}