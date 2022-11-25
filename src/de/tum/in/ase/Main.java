package de.tum.in.ase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    //TODO create classes Participant, Lecturer, ExerciseInstructor, Tutor, Student according to UML diagrams (Hint: inheritance)
//    LectureHall lectureHall1 = new LectureHall("LectureHall1", 270);
//    LectureHall lectureHall2 = new LectureHall("LectureHall2", 90);
////  String id, String name, List<Student> students, List<Tutor> tutors, List<ExerciseInstructor> exerciseInstructors, Lecturer lecturer, LectureHall lectureHall
//    List<Student> studentList1 = generateStudents(100);
//    List<Student> studentList2 = generateStudents(50);
//    List<Student> studentList3 = generateStudents(250);
//    List<Tutor> tutorList1 = generateTutors(16, lecture1);
//    List<Tutor> tutorList2 = generateTutors(6, lecture2);
//    List<Tutor> tutorList3 = generateTutors(34, lecture3);
//    List<ExerciseInstructor> exerciseInstructorList1 = generateExerciseInstructor(4, lecture1);
//    List<ExerciseInstructor> exerciseInstructorList2 = generateExerciseInstructor(3, lecture2);
//    List<ExerciseInstructor> exerciseInstructorList3 = generateExerciseInstructor(9, lecture3);
//    Lecture lecture1 = new Lecture("1","lecture1", studentList1, tutorList1, exerciseInstructorList1, lecturer1, lectureHall1);
//    Lecture lecture2 = new Lecture("1","lecture2", studentList2, tutorList2, exerciseInstructorList2, lecturer2, lectureHall1);
//    Lecture lecture3 = new Lecture("1","lecture3", studentList3, tutorList3, exerciseInstructorList3, lecturer3, lectureHall1);
//    List<Lecture> lectures = new ArrayList<>();
//    lectures.add(lecture1);
//
//    Participant lecturer1 = new Lecturer("Elon", "Musk", generateTumID(), "Professor", );
//    Participant NickBostrom = new ExerciseInstructor("Nick", "Bostrom", generateTumID(), lecture1);

    //TODO create classes Lecture and LectureHall
    //TODO implement toString() methods
    //TODO implement methods addParticipant and addParticipants in Lecture
    //TODO implement openLecture() and closeLecture() in Lecturer
    //TODO implement methods in LectureHall
    //TODO implement method takePlace() in Lecture

    public static void main(String[] args){
        //TODO test your code here
    }


    //TODO implement methods generateStudents and generateTutors
    //TODO think of the most suitable access modifier for those helper methods

    public static List<Student> generateStudents(int amount){
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            studentList.add(new Student("Student", Integer.toString(i), generateTumID()));
        }
        return studentList;
    }

    public static String generateTumID() {

        final String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();

        final String digits = "0123456789";

        StringBuilder tumID = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            Random random = new Random();
            int ranIndex = random.nextInt(alphabets.length());
            tumID.append(alphabets.charAt(ranIndex));
        }
        for (int i = 0; i < 2; i++) {
            Random random = new Random();
            int ranIndex = random.nextInt(digits.length());
            tumID.append(digits.charAt(ranIndex));
        }
        for (int i = 0; i < 3; i++) {
            Random random = new Random();
            int ranIndex = random.nextInt(alphabets.length());
            tumID.append(alphabets.charAt(ranIndex));
        }
        return tumID.toString();
    }

    public static List<Tutor> generateTutors(int amount,Lecture lecture){
        List<Tutor> tutorList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            tutorList.add(new Tutor("Tutor", Integer.toString(i), generateTumID(), lecture));
        }
        return tutorList;
    }

    public static List<ExerciseInstructor> generateExerciseInstructor(int amount,Lecture lecture){
        List<ExerciseInstructor> exerciseInstructorList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            exerciseInstructorList.add(new ExerciseInstructor("ExerciseInstructor", Integer.toString(i), generateTumID(), lecture));
        }
        return exerciseInstructorList;
    }


}
