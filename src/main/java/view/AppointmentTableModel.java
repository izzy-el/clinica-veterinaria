/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.sql.Date;
import java.util.List;
import model.Appointment;
import model.AppointmentDAO;

/**
 *
 * @author izael
 */
public class AppointmentTableModel extends GenericTableModel{
    public AppointmentTableModel(List vDados) {
        super(vDados, new String[]{"Data", "Horario", "Comentario", "Done"});
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
                
//            case 3:
//                return String.class;
//                
//            case 4:
//                return String.class;
//                
//            case 5:
//                return String.class;
            
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Appointment appointment = (Appointment) vDados.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return appointment.getDate();
            
            case 1:
                return appointment.getTime();
                
            case 2:
                return appointment.getComments();
                
            case 3:
                return appointment.isDone();
                
//            case 3:
//                return appointment.getIdAnimal();
//                
//            case 4:
//                return appointment.getIdVet();
//                
//            case 5:
//                return appointment.getIdTreatment();
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Appointment appointment = (Appointment) vDados.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                appointment.setDate((Date) value);
                break;
            
            case 1:
                appointment.setTime((String) value);
                break;
                
            case 2:
                appointment.setComments((String) value);
                break;
                
            case 3:
                appointment.setDone((Boolean) value);
                break;
                
//            case 3:
//                appointment.setIdAnimal((Integer) value);
//                break;
//                
//            case 4:
//                appointment.setIdVet((Integer) value);
//                break;
//                
//            case 5:
//                appointment.setIdTreatment((Integer) value);
//                break;
                
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
                
        }
        
        AppointmentDAO.getInstance().update(appointment);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
}
