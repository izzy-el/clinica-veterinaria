import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        TreatmentDAO treatmentDAO;
        treatmentDAO = TreatmentDAO.getInstance();
        Treatment treatment = treatmentDAO.retrieveAll().get(0);
        if(treatment == null) {
            System.out.println("BRUH!");
        }
//        System.out.println(treatment);

//        treatmentDAO.create(1, "Vaccine", Calendar.getInstance(), Calendar.getInstance(), true);
//        ClientDAO clientDAO;
//        AnimalDAO animalDAO;

//        clientDAO = ClientDAO.getInstance();
//        animalDAO = AnimalDAO.getInstance();
//
//        Client client = clientDAO.retrieveById(1);
//        client.addAnimal(animalDAO.retrieveByClientId(client));
//
//        System.out.println(client.toString());
    }
}