package de.tum.in.ase;

public class ExerciseInstructor extends Participant {

    private Lecture lecture;

    public ExerciseInstructor(String firstName, String lastName, String tumID, Lecture lecture) {
        super(firstName, lastName, tumID);
        this.lecture = lecture;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    //    If the Tutor/ExerciseInstructor attends a Lecture he or she is not tutoring in,
//    he/she gets added as a Student (a new student object must be created).
//    Otherwise he/she gets added as explained above.
    @Override
    public void attend(Lecture lecture) {
        if (!this.getLecture().equals(lecture)) {
            lecture.addParticipant(new Student(this.getFirstName(), this.getLastName(), this.getTumID()));
        } else {
            lecture.addParticipant(this);
        }
    }

    @Override
    public String toString () {
        return "Exercise Instructor " + this.getName();
    }
}


