package controller;

import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.Client;
import model.Animal;
import model.Appointment;
import model.Exam;
import model.ExamDAO;
import model.Treatment;
import model.Veterinarian;
import view.GenericTableModel;

/**
 * 
 * @author izael
 */

public class Controller {
    private static Client selectedClient = null;
    private static JTextField selectedClientTextField = null;
    private static JTextField selectedClientNameTextField = null;
    private static JTextField selectedClientPhoneTextField = null;
    private static JTextField selectedClientEmailTextField = null;
    private static JTextField selectedClientCepTextField = null;
    private static JTextField selectedClientAddressTextField = null;
    
    private static Animal selectedAnimal = null;
    private static JTextField selectedAnimalTextField = null;
    private static JTextField selectedAnimalNameTextField = null;
    private static JTextField selectedAnimalAgeTextField = null;
    private static JTextField selectedAnimalGenderTextField = null;
    private static JTextField selectedAnimalSpecieTextField = null;
    
    private static Treatment selectedTreatment = null;
    private static JTextField selectedTreatmentTextField = null;
    private static JTextField selectedTreatmentNameTextField = null;
    private static JTextField selectedTreatmentNameOnAppointmentTextField = null;
    private static JDateChooser selectedTreatmentInitialDateTextField = null;
    private static JDateChooser selectedTreatmentEndDateTextField = null;
    
    private static Veterinarian selectedVeterinarian = null;
    private static JTextField selectedVeterinarianTextField = null;
    private static JTextField selectedVeterinarianNameTextField = null;
    private static JTextField selectedVeterinarianAddressTextField = null;
    private static JTextField selectedVeterinarianPhoneTextField = null;
    private static JTextField selectedVeterinarianEmailTextField = null;
    
    private static Appointment selectedAppointment = null;
    private static JDateChooser selectedAppointmentDataTextField = null;
    private static JTextField selectedAppointmentHorarioTextField = null;
    private static JTextField selectedAppointmentCommentTextField = null;
    private static JTextArea selectedAppointmentCommentOnAppointmentTextField = null;
    
    private static Exam selectedExam = null;
    private static JTextField selectedExamTextField = null;
    
    
    public static void setTableModel(JTable table, GenericTableModel tableModel) {
        table.setModel(tableModel);
    }
    
    public static void setExamListModel(JList list) {
        DefaultListModel listModel = new DefaultListModel();
        ArrayList<Exam> listWithData = ExamDAO.getInstance().retrieveByAppointmentId(Controller.getSelectedAppointment().getId());
        for(int i = 0; i < listWithData.size(); i++) {
            listModel.addElement(listWithData.get(i).getExamName());
        }
        list.setModel(listModel);
    }
    
    public static void setTextFields(JTextField client, JTextField animal, JTextField treatment) {
        selectedClientTextField = client;
        selectedAnimalTextField = animal;
        selectedTreatmentTextField = treatment;
    }
    
    public static void setClientsInfoTextFields(JTextField clientName, JTextField clientPhone, JTextField clientEmail, JTextField clientCep, JTextField clientAddress) {
        selectedClientNameTextField = clientName;
        selectedClientPhoneTextField = clientPhone;
        selectedClientEmailTextField = clientEmail;
        selectedClientCepTextField = clientCep;
        selectedClientAddressTextField = clientAddress;
    }
    
    public static void setAnimalInfoTextFields(JTextField animalName, JTextField animalAge, JTextField animalGender, JTextField animalSpecie) {
        selectedAnimalNameTextField = animalName;
        selectedAnimalAgeTextField = animalAge;
        selectedAnimalGenderTextField = animalGender;
        selectedAnimalSpecieTextField = animalSpecie;
    }
    
    public static void setTreatmentInfoTextFields(JTextField treatmentNameOnAppointment, JTextField treatmentName, JDateChooser treatmentInitialDate, JDateChooser treatmentEndDate) {
        selectedTreatmentNameTextField = treatmentName;
        selectedTreatmentInitialDateTextField = treatmentInitialDate;
        selectedTreatmentEndDateTextField = treatmentEndDate;
        selectedTreatmentNameOnAppointmentTextField = treatmentNameOnAppointment;
    }
    
    public static void setVeterinarianInfoTextFields(JTextField vet, JTextField veterinarianName, JTextField veterinarianAddress, JTextField veterinarianPhone, JTextField veterinarianEmail) {
        selectedVeterinarianTextField = vet;
        selectedVeterinarianNameTextField = veterinarianName;
        selectedVeterinarianAddressTextField = veterinarianAddress;
        selectedVeterinarianPhoneTextField = veterinarianPhone;
        selectedVeterinarianEmailTextField = veterinarianEmail;
        
    }
    
    public static void setAppointmentInfoTextFields(JDateChooser data, JTextField comment, JTextArea commentOnAppointment) {
        selectedAppointmentDataTextField = data;
        selectedAppointmentCommentTextField = comment;
        selectedAppointmentCommentOnAppointmentTextField = commentOnAppointment;
    }
    
    public static void setExamInfoTextFields(JTextField exam) {
        selectedExamTextField = exam;
    }
    
    public static Client getSelectedClient() {
        return selectedClient;
    }
    
    public static Animal getSelectedAnimal() {
        return selectedAnimal;
    }
    
    public static Veterinarian getSelectedVet() {
        return selectedVeterinarian;
    }
    
    public static Treatment getSelectedTreatment() {
        return selectedTreatment;
    }
    
    public static Appointment getSelectedAppointment() {
        return selectedAppointment;
    }
    
    public static Exam getSelectedExam() {
        return selectedExam;
    }
    
    public static void setSelected(Object selected) {
        if(selected instanceof Client) {
            selectedClient = (Client) selected;
            selectedClientTextField.setText(selectedClient.getName());
            selectedClientNameTextField.setText(selectedClient.getName());
            selectedClientPhoneTextField.setText(selectedClient.getPhone());
            selectedClientEmailTextField.setText(selectedClient.getEmail());
            selectedClientCepTextField.setText(selectedClient.getCep());
            selectedClientAddressTextField.setText(selectedClient.getAddress());
            selectedAnimalTextField.setText("");
            selectedAnimalNameTextField.setText("");
            selectedAnimalAgeTextField.setText("");
            selectedAnimalGenderTextField.setText("");
            selectedAnimalSpecieTextField.setText("");
            selectedTreatmentTextField.setText("");
            selectedTreatmentNameTextField.setText("");
            selectedTreatmentNameOnAppointmentTextField.setText("");
            selectedTreatmentInitialDateTextField.setDate(null);
            selectedTreatmentEndDateTextField.setDate(null);
            selectedAppointmentDataTextField.setDate(null);
            selectedAppointmentCommentTextField.setText("");
            selectedAppointmentCommentOnAppointmentTextField.setText("");
        } else if(selected instanceof Animal) {
            selectedAnimal = (Animal) selected;
            selectedAnimalTextField.setText(selectedAnimal.getName());
            selectedAnimalNameTextField.setText(selectedAnimal.getName());
            selectedAnimalAgeTextField.setText(String.valueOf(selectedAnimal.getAge()));
            selectedAnimalGenderTextField.setText(selectedAnimal.getGender());
            selectedAnimalSpecieTextField.setText(selectedAnimal.getSpecie());
            selectedTreatmentTextField.setText("");
            selectedTreatmentNameTextField.setText("");
            selectedTreatmentInitialDateTextField.setDate(null);
            selectedTreatmentEndDateTextField.setDate(null);
            selectedTreatmentTextField.setText("");
            selectedTreatmentNameTextField.setText("");
            selectedTreatmentNameOnAppointmentTextField.setText("");
            selectedTreatmentInitialDateTextField.setDate(null);
            selectedTreatmentEndDateTextField.setDate(null);
            selectedAppointmentDataTextField.setDate(null);
            selectedAppointmentCommentTextField.setText("");
            selectedAppointmentCommentOnAppointmentTextField.setText("");
        } else if(selected instanceof Treatment) {
            selectedTreatment = (Treatment) selected;
            selectedTreatmentTextField.setText(selectedTreatment.getName());
            selectedTreatmentNameTextField.setText(selectedTreatment.getName());
            selectedTreatmentInitialDateTextField.setDate(selectedTreatment.getInitialDate());
            selectedTreatmentEndDateTextField.setDate(selectedTreatment.getEndDate());
            selectedTreatmentNameOnAppointmentTextField.setText(selectedTreatment.getName());
            selectedAppointmentDataTextField.setDate(null);
            selectedAppointmentCommentTextField.setText("");
            selectedAppointmentCommentOnAppointmentTextField.setText("");
        } else if(selected instanceof Veterinarian) {
            selectedVeterinarian = (Veterinarian) selected;
            selectedVeterinarianTextField.setText(selectedVeterinarian.getVetName());
            selectedVeterinarianNameTextField.setText(selectedVeterinarian.getVetName());
            selectedVeterinarianAddressTextField.setText(selectedVeterinarian.getVetAddress());
            selectedVeterinarianPhoneTextField.setText(selectedVeterinarian.getVetPhone());
            selectedVeterinarianEmailTextField.setText(selectedVeterinarian.getVetEmail());
            selectedTreatmentTextField.setText("");
            selectedTreatmentNameTextField.setText("");
            selectedTreatmentNameOnAppointmentTextField.setText("");
            selectedTreatmentInitialDateTextField.setDate(null);
            selectedTreatmentEndDateTextField.setDate(null);
            selectedAppointmentDataTextField.setDate(null);
            selectedAppointmentCommentTextField.setText("");
            selectedAppointmentCommentOnAppointmentTextField.setText("");
        } else if(selected instanceof Appointment) {
            selectedAppointment = (Appointment) selected;
            selectedAppointmentDataTextField.setDate(selectedAppointment.getDate());
            selectedAppointmentCommentTextField.setText(selectedAppointment.getComments());
            selectedAppointmentCommentOnAppointmentTextField.setText(selectedAppointment.getComments());
        } else if(selected instanceof Exam) {
            selectedExam = (Exam) selected;
            selectedExamTextField.setText(selectedExam.getExamName());
        }
    }
        
}
