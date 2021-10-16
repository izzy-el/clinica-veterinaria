package view;

import java.util.List;
import model.Animal;
import model.Client;
import model.AnimalDAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author izael
 */
public class AnimalTableModel extends GenericTableModel {
    public AnimalTableModel(List vDados) {
        super(vDados, new String[]{"Name", "Age", "Gender", "Specie"});
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 0:
                return String.class;

            case 1:
                return Integer.class;

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
        Animal animal = (Animal) vDados.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                return animal.getName();

            case 1:
                return animal.getAge();

            case 2:
                return animal.getGender();

            case 3:
                return animal.getSpecie();

            default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Animal animal = (Animal) vDados.get(rowIndex);
        
        switch(columnIndex) {
            case 0:
                animal.setName((String) value);
                break;

            case 1:
                animal.setAge((Integer) value);

            case 2:
                animal.setGender((String) value);

            case 3:
                animal.setSpecie((String) value);

            default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        AnimalDAO.getInstance().update(animal);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
