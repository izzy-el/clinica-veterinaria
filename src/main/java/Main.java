import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        TreatmentDAO treatmentDAO;
        treatmentDAO = TreatmentDAO.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Treatment treatment = treatmentDAO.retrieveById(1);
        System.out.println(treatment);

//        treatmentDAO.create(1, "Vaccine", sdf.parse("26/01/2002"), sdf.parse("27/01/2002"), true);
//        Treatment treatment = treatmentDAO.retrieveById(3);
//        System.out.println(treatment);

//        Treatment treatment = treatmentDAO.retrieveAll().get(0);

//        ClientDAO clientDAO;
//        AnimalDAO animalDAO;

//        clientDAO = ClientDAO.getInstance();
//        animalDAO = AnimalDAO.getInstance();
//
//        Client client = clientDAO.retrieveById(1);
//        System.out.println(client);
//        client.addAnimal(animalDAO.retrieveByClientId(client));
//
//        System.out.println(client.toString());
    }
}