package de.tum.in.ase;


import java.util.*;

public class Lecture {
    private String id;
    private String name;
    private List<Student> students;
    private List<Tutor> tutors;
    private List<ExerciseInstructor> exerciseInstructors;
    private Lecturer lecturer;
    private LectureHall lectureHall;

    public Lecture(String id, String name, Lecturer lecturer, LectureHall lectureHall) {
        this.id = id;
        this.name = name;
        this.students = new ArrayList<>();
        this.tutors =  new ArrayList<>();
        this.exerciseInstructors =  new ArrayList<>();
        this.lecturer = lecturer;
        this.lectureHall = lectureHall;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Tutor> getTutors() {
        return tutors;
    }

    public void setTutors(List<Tutor> tutors) {
        this.tutors = tutors;
    }

    public List<ExerciseInstructor> getExerciseInstructors() {
        return exerciseInstructors;
    }

    public void setExerciseInstructors(List<ExerciseInstructor> exerciseInstructors) {
        this.exerciseInstructors = exerciseInstructors;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public LectureHall getLectureHall() {
        return lectureHall;
    }

    public void setLectureHall(LectureHall lectureHall) {
        this.lectureHall = lectureHall;
    }

//    adds a Participant to the according list (or attribute in case of Lecturer).
//    For example if the participant is a Student he or she should be added to the list of students.
//    The method addParticipants works pretty much the same.
//    Only difference here is that the method parameter is a list of Participants,
//    so the steps have to be done for every single Participant now.
    public void addParticipant(Participant participant) {
        if (students.contains(participant) || tutors.contains(participant) || exerciseInstructors.contains(participant) || lecturer.equals(participant)) {
            System.out.printf("%S tumID:%s already attends/holds the lecture.%n", participant.getName(), participant.getTumID());
        }
        else {
            String className = participant.getClass().getSimpleName();
            switch (className) {
                case "Student":
                    students.add((Student) participant);
                    break;
                case "Tutor":
                    tutors.add((Tutor) participant);
                    break;
                case "ExerciseInstructor":
                    exerciseInstructors.add((ExerciseInstructor) participant);
                    break;
                case "Lecturer":
                    if (!lecturer.equals(participant)) {
                        System.out.println("This lecture already has a lecturer!");
                    } else {
                        setLecturer((Lecturer) participant);
                        ((Lecturer) participant).getLectures().add(this);
                    }
                    break;
                default:
                    System.out.println("No such participants allowed in this lecture!");
                    break;
            }
        }
    }
    public void addParticipants(List<Participant> participants) {
        if (!participants.isEmpty()) {
            for (Participant participant : participants) {
                addParticipant(participant);
            }
        }
    }
    public void takePlace() {
        lectureHall.placeStudents(students);
        lecturer.openLecture(this);
        lecturer.closeLecture(this);
        lectureHall.empty();
    }

}
