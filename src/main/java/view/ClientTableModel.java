package view;

import java.util.List;
import model.Client;
import model.ClientDAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author izael
 */
public class ClientTableModel extends GenericTableModel {
    public ClientTableModel(List vDados) {
        super(vDados, new String[]{"Name", "Address", "Phone", "CEP", "Email"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 1:
                return String.class;
            
            case 2:
                return String.class;
            
            case 3:
                return String.class;
                
            case 4:
                return String.class;
            
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Client client = (Client) vDados.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return client.getName();
            
            case 1:
                return client.getAddress();
                
            case 2:
                return client.getPhone();
                
            case 3:
                return client.getCep();
                
            case 4:
                return client.getEmail();
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Client client = (Client) vDados.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                client.setName((String) value);
                break;
            
            case 1:
                client.setAddress((String) value);
                break;
                
            case 2:
                client.setPhone((String) value);
                break;
                
            case 3:
                client.setCep((String) value);
                break;
                
            case 4:
                client.setEmail((String) value);
                break;
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
                
        }
        
        ClientDAO.getInstance().update(client);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
}
