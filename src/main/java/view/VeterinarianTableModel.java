package view;

import java.util.List;
import model.Veterinarian;
import model.VeterinarianDAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author izael
 */
public class VeterinarianTableModel extends GenericTableModel {
    public VeterinarianTableModel(List vDados) {
        super(vDados, new String[]{"Name", "Address", "Phone", "Email"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 0:
                return String.class;
            
            case 1:
                return String.class;
            
            case 2:
                return String.class;
                
            case 3:
                return String.class;
            
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veterinarian veterinarian = (Veterinarian) vDados.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return veterinarian.getVetName();
            
            case 1:
                return veterinarian.getVetAddress();
                
            case 2:
                return veterinarian.getVetPhone();
                
            case 3:
                return veterinarian.getVetEmail();
                                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Veterinarian veterinarian = (Veterinarian) vDados.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                veterinarian.setVetName((String) value);
                break;
            
            case 1:
                veterinarian.setVetAddress((String) value);
                break;
                
            case 2:
                veterinarian.setVetPhone((String) value);
                break;
                
            case 3:
                veterinarian.setVetEmail((String) value);
                break;
                                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
        
        VeterinarianDAO.getInstance().update(veterinarian);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
}
