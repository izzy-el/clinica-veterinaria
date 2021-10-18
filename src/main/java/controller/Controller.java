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
    private static Animal selectedAnimal = null;
    private static JTextField selectedAnimalTextField = null;
    
    public static void setTableModel(JTable table, GenericTableModel tableModel) {
        table.setModel(tableModel);
    }
    
    public static void setTextFields(JTextField client, JTextField animal) {
        selectedClientTextField = client;
        selectedAnimalTextField = animal;
    }
    
    public static Client getSelectedClient() {
        return selectedClient;
    }
    
    public static Animal getSelectedAnimal() {
        return selectedAnimal;
    }
    
    public static void setClientSelected(Object selected) {
        selectedClient = (Client) selected;
        selectedClientTextField.setText(selectedClient.getName());
    }
    
     public static void setAnimalSelected(Object selected) {
        selectedAnimal = (Animal) selected;
        selectedAnimalTextField.setText(selectedAnimal.getName());
     }
    
}
