package controller;

import javax.swing.JTable;
import javax.swing.JTextField;
import model.Client;
import model.Animal;
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
    
    public static void setTableModel(JTable table, GenericTableModel tableModel) {
        table.setModel(tableModel);
    }
    
    public static void setTextFields(JTextField client, JTextField animal) {
        selectedClientTextField = client;
        selectedAnimalTextField = animal;
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
    
    public static Client getSelectedClient() {
        return selectedClient;
    }
    
    public static Animal getSelectedAnimal() {
        return selectedAnimal;
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
        } else if(selected instanceof Animal) {
            selectedAnimal = (Animal) selected;
            selectedAnimalTextField.setText(selectedAnimal.getName());
            selectedAnimalNameTextField.setText(selectedAnimal.getName());
            selectedAnimalAgeTextField.setText(String.valueOf(selectedAnimal.getAge()));
            selectedAnimalGenderTextField.setText(selectedAnimal.getGender());
            selectedAnimalSpecieTextField.setText(selectedAnimal.getSpecie());
        }
    }
        
}
