/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import model.Treatment;
import model.TreatmentDAO;

/**
 *
 * @author izael
 */
public class TreatmentTableModel extends GenericTableModel {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public TreatmentTableModel(List vDados) {
        super(vDados, new String[]{"Name", "InitialDate", "EndDate", "Done"});
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
                return Boolean.class;
            
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Treatment treatment = (Treatment) vDados.get(rowIndex);
        
        switch(columnIndex) {            
            case 0:
                return treatment.getName();
                
            case 1:
                return sdf.format(treatment.getInitialDate());
                
            case 2:
                return sdf.format(treatment.getEndDate());
                
            case 3:
                return treatment.isDone();
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Treatment treatment = (Treatment) vDados.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                treatment.setName((String) value);
                break;
                
            case 1:
                try {
                    treatment.setInitialDate(sdf.parse((String) value));
                } catch(ParseException e) {
                    e.getMessage();
                }
                break;

                
            case 2:
                try {
                    treatment.setEndDate(sdf.parse((String) value));
                } catch(ParseException e) {
                    e.getMessage();
                }
                break;
                
            case 3:
                treatment.setDone((Boolean) value);
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
