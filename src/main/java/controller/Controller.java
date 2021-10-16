package controller;

import javax.swing.JTable;
import javax.swing.JTextField;
import model.Client;
import view.GenericTableModel;

/**
 * 
 * @author izael
 */

public class Controller {
    private static Client selectedClient = null;
    private static JTextField selectedClientTextField = null;
    
    public static void setTableModel(JTable table, GenericTableModel tableModel) {
        table.setModel(tableModel);
    }
    
    public static void setTextFields(JTextField client) {
        selectedClientTextField = client;
    }
    
    public static Client getSelectedClient() {
        return selectedClient;
    }
    
    public static void setSelected(Object selected) {
        selectedClient = (Client) selected;
        selectedClientTextField.setText(selectedClient.getName());
    }
}
