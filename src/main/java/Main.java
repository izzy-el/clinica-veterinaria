public class Main {
    public static void main(String[] args) {
        ClientDAO clientDAO;
        AnimalDAO animalDAO;

        clientDAO = ClientDAO.getInstance();
        animalDAO = AnimalDAO.getInstance();

        Client client = clientDAO.retrieveById(1);
        client.addAnimal(animalDAO.retrieveByClientId(client));

        System.out.println(client.toString());
    }
}