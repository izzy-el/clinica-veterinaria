public class Veterinarian {
    //Attributes
    private String vetName;
    private String vetAddress;
    private String vetPhone;

    //Constructor
    public Veterinarian(String vetName, String vetAddress, String vetPhone) {
        this.vetName = vetName;
        this.vetAddress = vetAddress;
        this.vetPhone = vetPhone;
    }

    //Getters
    public String getVetName() {
        return vetName;
    }

    public String getVetAddress() {
        return vetAddress;
    }

    public String getVetPhone() {
        return vetPhone;
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
}
