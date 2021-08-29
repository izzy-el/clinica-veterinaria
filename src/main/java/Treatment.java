import java.util.Calendar;

public class Treatment {
    //Attributes
    private String name;
    private Calendar endDate;
    private Calendar initialDate;
    private int idAnimal;
    private boolean done;

    //Constructor
    public Treatment(String name, Calendar endDate, Calendar initialDate, int idAnimal, boolean done) {
        this.name = name;
        this.endDate = endDate;
        this.initialDate = initialDate;
        this.idAnimal = idAnimal;
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

}
