import java.util.Calendar;

public class Consult {
    //Attributes
    private Calendar consultDate;
    private String historic;

    //Constructor
    public Consult(Calendar consultDate, String historic) {
        this.consultDate = consultDate;
        this.historic = historic;
    }

    //Getters
    public Calendar getConsultDate() {
        return consultDate;
    }

    public String getHistoric() {
        return historic;
    }

    //Setters
    public void setConsultDate(Calendar consultDate) {
        this.consultDate = consultDate;
    }

    public void setHistoric(String historic) {
        this.historic = historic;
    }
}
