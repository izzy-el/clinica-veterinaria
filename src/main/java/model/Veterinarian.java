package model;

public class Veterinarian {
    //Attributes
    private int id;
    private String vetName;
    private String vetAddress;
    private String vetPhone;
    private String vetEmail;

    //Constructor
    public Veterinarian(int id, String vetName, String vetAddress, String vetPhone, String vetEmail) {
        this.id = id;
        this.vetName = vetName;
        this.vetAddress = vetAddress;
        this.vetPhone = vetPhone;
        this.vetEmail = vetEmail;
    }

    //Getters
    public int getId() {
        return id;
    }
    
    public String getVetName() {
        return vetName;
    }

    public String getVetAddress() {
        return vetAddress;
    }

    public String getVetPhone() {
        return vetPhone;
    }

    public String getVetEmail() {
        return vetEmail;
    }

    //Setters
    public void setVetName(String vetName) {
        this.vetName = vetName;
    }

    public void setVetAddress(String vetAddress) {
        this.vetAddress = vetAddress;
    }

    public void setVetPhone(String vetPhone) {
        this.vetPhone = vetPhone;
    }

    public void setVetEmail(String vetEmail) {
        this.vetEmail = vetEmail;
    }
}