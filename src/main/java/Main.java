public class Main {
    public static void main(String[] args) {

        ClientDAO clientDAO;
        AnimalDAO animalDAO;

        clientDAO = ClientDAO.getInstance();
        animalDAO = AnimalDAO.getInstance();

        System.out.println(clientDAO.retrieveById(1));
        System.out.println(animalDAO.retrieveByClientId(1));

    }
}