/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.sql.Date;
import java.util.List;
import model.Treatment;
import model.TreatmentDAO;

/**
 *
 * @author izael
 */
public class TreatmentTableModel extends GenericTableModel{
    public TreatmentTableModel(List vDados) {
        super(vDados, new String[]{"IDAnimal", "Name", "InitialDate", "EndDate", "Done"});
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
                
            case 4:
                return String.class;
            
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Treatment treatment = (Treatment) vDados.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return treatment.getIdAnimal();
            
            case 1:
                return treatment.getName();
                
            case 2:
                return treatment.getInitialDate();
                
            case 3:
                return treatment.getEndDate();
                
            case 4:
                return treatment.isDone();
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Treatment treatment = (Treatment) vDados.get(rowIndex);
        
        switch(columnIndex) {
//            case 0:
//                treatment.
//                break;
            
            case 1:
                treatment.setName((String) value);
                break;
                
            case 2:
                treatment.setInitialDate((Date) value);
                break;
                
            case 3:
                treatment.setEndDate((Date) value);
                break;
                
            case 4:
                treatment.setDone((boolean) value);
                break;
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
                
        }
        
        TreatmentDAO.getInstance().update(treatment);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
}
