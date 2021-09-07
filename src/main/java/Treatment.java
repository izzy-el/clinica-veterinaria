import java.sql.Date;
import java.util.Calendar;

public class Treatment {
    //Attributes
    private String name;
    private Calendar endDate;
    private Calendar initialDate;
    private int idAnimal;
    private boolean done;

    //Constructor
    public Treatment(int idAnimal, String name, Calendar initialDate, Calendar endDate, boolean done) {
        this.idAnimal = idAnimal;
        this.name = name;
        this.initialDate = initialDate;
        this.endDate = endDate;
        this.done = done;
    }

    //Getters
    public String getName() {
        return name;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public Calendar getInitialDate() {
        return initialDate;
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

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public void setInitialDate(Calendar initialDate) {
        this.initialDate = initialDate;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    //Methods
    @Override
    public String toString() {
        return "Calendar [\n\tIDAnimal: " + idAnimal + "\n\tNome: " + name + "\n\tInitial Date: " + initialDate.getTime() + "\n\tEnd Date: " + endDate.getTime() + "\n\tDone: " + done + "\n]";
    }

}
