import java.sql.*;

public class Main {
    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (Exception e) {
//            System.out.println("Exception in loading the driver: " + e);
//        }
        Client cliente = new Client("Meu Nome", "Rua Minha", "##-#####-####", "########", "JV");
        Animal animal = new Animal(1, "Anonymous", 3, 1);
        DAO.connect();
        cliente.addAnimal(animal);
        System.out.println(cliente.toString());
        System.out.println(animal.toString());
    }
}