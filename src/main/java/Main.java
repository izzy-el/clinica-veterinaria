import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        AnimalDAO animalDAO;
        animalDAO = AnimalDAO.getInstance();
        AppointmentDAO appointmentDAO;
        appointmentDAO = AppointmentDAO.getInstance();
        ClientDAO clientDAO;
        clientDAO = ClientDAO.getInstance();
        ExamDAO examDAO;
        examDAO = ExamDAO.getInstance();
        SpeciesDAO speciesDAO;
        speciesDAO = SpeciesDAO.getInstance();
        TreatmentDAO treatmentDAO;
        treatmentDAO = TreatmentDAO.getInstance();
        VeterinarianDAO veterinarianDAO;
        veterinarianDAO = VeterinarianDAO.getInstance();

        clientDAO.create("Amy", "Rua Alberta", "523667895", "256032", "amy@gmail.com");
        animalDAO.create("Spartan", 3, "Male", 3);
        veterinarianDAO.create("Scott", "Rua das Americas", "526227485", "scot@gmail.com");
        speciesDAO.create("Horse");
        treatmentDAO.create(6, "Surgery", sdf.parse("12/09/2021"), sdf.parse("12/09/2021"), false);
        appointmentDAO.create(sdf.parse("12/09/2021"), "15:00", "None", 6, 1, 1, false);
        examDAO.create("Surgery Checkup", 1);
    }
}