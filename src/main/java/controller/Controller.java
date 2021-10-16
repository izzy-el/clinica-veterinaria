package controller;

import javax.swing.JTable;
import view.GenericTableModel;

/**
 * 
 * @author izael
 */

public class Controller {
    public static void setTableModel(JTable table, GenericTableModel tableModel) {
        table.setModel(tableModel);
    }
}
