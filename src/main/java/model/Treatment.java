package model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Treatment {
    //Attributes
    private int id;
    private String name;
    private Date endDate;
    private Date initialDate;
    private int idAnimal;
    private boolean done;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    //Constructor
    public Treatment(int id, int idAnimal, String name, Date initialDate, Date endDate, boolean done) {
        this.id = id;
        this.idAnimal = idAnimal;
        this.name = name;
        this.initialDate = initialDate;
        this.endDate = endDate;
        this.done = done;
    }

    //Getters
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public boolean isDone() {
        return done;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    //Methods
    @Override
    public String toString() {
        return "Calendar [\n\tIDAnimal: " + idAnimal + "\n\tNome: " + name + "\n\tInitial Date: " + sdf.format(initialDate) + "\n\tEnd Date: " + sdf.format(endDate) + "\n\tDone: " + done + "\n]";
    }

}