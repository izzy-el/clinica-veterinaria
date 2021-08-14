public class Main {
    public static void main(String[] args) {
        Client cliente = new Client("Meu Nome", "Rua Minha", "##-#####-####", "########", "JV");
        Animal animal = new Animal(1, "Anonymous", 3, 1);
        System.out.println(cliente.toString());
        System.out.println(animal.toString());
    }
}