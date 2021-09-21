package model;

import java.util.Date;

public class Appointment {
    private Date date;
    private String time;
    private String comments;
    private int idAnimal;
    private int idVet;
    private int idTreatment;
    private boolean done;

    //Constructor
    public Appointment(Date date, String time, String comments, int idAnimal, int idVet, int idTreatment, boolean done) {
        this.date = date;
        this.time = time;
        this.comments = comments;
        this.idAnimal = idAnimal;
        this.idVet = idVet;
        this.idTreatment = idTreatment;
        this.done = done;
    }

    //Getters
    public Date getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getComments() {
        return comments;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public int getIdVet() {
        return idVet;
    }

    public int getIdTreatment() {
        return idTreatment;
    }

    public boolean isDone() {
        return done;
    }

    //Setters
    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public void setIdVet(int idVet) {
        this.idVet = idVet;
    }

    public void setIdTreatment(int idTreatment) {
        this.idTreatment = idTreatment;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
