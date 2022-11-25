package de.tum.in.ase;

public class Student extends Participant {

    public Student(String firstName, String lastName, String tumID) {
        super(firstName, lastName, tumID);
    }

//    add the according Participant by invoking the addParticipant method of Lecture
    @Override
    public void attend(Lecture lecture) {
        lecture.addParticipant(this);
    }

}
