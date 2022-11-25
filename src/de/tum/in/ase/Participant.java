package de.tum.in.ase;

public abstract class Participant {

    private String firstName;
    private String lastName;
    private String tumID;

    protected Participant(String firstName, String lastName, String tumID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tumID = tumID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTumID() {
        return tumID;
    }

    public void setTumID(String tumID) {
        this.tumID = tumID;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public void attend(Lecture lecture) {}
}
