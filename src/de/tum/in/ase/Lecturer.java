package de.tum.in.ase;

import java.util.*;

public class Lecturer extends Participant {
    private String title;

    private List<Lecture> lectures;

    public Lecturer(String firstName, String lastName, String tumID, String title) {
        super(firstName, lastName, tumID);
        this.title = title;
        this.lectures = new ArrayList<>();
    }

    public String getName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }


//    should check if the passed Lecture already has a Lecturer or not.
//    if the Lecture already has a Lecturer you should print out the following to the console:
//    "The lecture [lecture name] is already held by another lecturer.".
//    Otherwise, add the lecture to the list of lectures.
    public void addLecture(Lecture lecture) {
        if (lecture.getLecturer() != null && !lecture.getLecturer().equals(this)) {
            System.out.printf("The lecture %s is already held by another lecturer.%n", lecture.getName());
        } else {
            this.lectures.add(lecture);
        }
    }

//    add the according Participant by invoking the addParticipant method of Lecture
    public void attend(Lecture lecture) {
        lecture.addParticipant(this);
    }

    public void openLecture(Lecture lecture) {
        System.out.printf("Welcome to the lecture %s! I'm Prof. %s.%n", lecture.getName(), this.getName());
    }

    public void closeLecture(Lecture lecture) {
        System.out.println("This is all for today. See you next week!");
    }

    @Override
    public String toString() {
        return this.getTitle() + " " + this.getName();
    }

}
