public class Exam {
    //Attributes
    private String examDesc;
    private int appointmentID;

    //Constructor
    public Exam(String examDesc, int appointmentID) {
        this.examDesc = examDesc;
        this.appointmentID = appointmentID;
    }

    //Getters
    public String getExamDesc() {
        return examDesc;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    //Setters
    public void setExamDesc(String examDesc) {
        this.examDesc = examDesc;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }
}
