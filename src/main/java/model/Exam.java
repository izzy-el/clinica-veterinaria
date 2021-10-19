package model;

public class Exam {
    //Attributes
    private String name;
    private int appointmentID;

    //Constructor
    public Exam(String name, int appointmentID) {
        this.name = name;
        this.appointmentID = appointmentID;
    }

    //Getters
    public String getExamName() {
        return name;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    //Setters
    public void setExamname(String name) {
        this.name = name;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }
}