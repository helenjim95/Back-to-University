package de.tum.in.ase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args){
        LectureHall lectureHall1 = new LectureHall("LectureHall1", 270);
        LectureHall lectureHall2 = new LectureHall("LectureHall2", 40);
        Lecturer lecturer1 = new Lecturer("Lecturer", "1", generateTumID(), "Professor");
        Lecturer lecturer2 = new Lecturer("Lecturer", "2", generateTumID(), "Professor");
        Lecture lecture1 = new Lecture("1","lecture1", lecturer1, lectureHall1);
        Lecture lecture2 = new Lecture("1","lecture2", lecturer2, lectureHall2);
        Lecture lecture3 = new Lecture("1","lecture3", lecturer1, lectureHall1);
        List<Student> studentList1 = generateStudents(100);
        List<Student> studentList2 = generateStudents(50);
        List<Student> studentList3 = generateStudents(250);
        List<Tutor> tutorList1 = generateTutors(16, lecture1);
        List<Tutor> tutorList2 = generateTutors(6, lecture2);
        List<Tutor> tutorList3 = generateTutors(34, lecture3);
        List<ExerciseInstructor> exerciseInstructorList1 = generateExerciseInstructor(4, lecture1);
        List<ExerciseInstructor> exerciseInstructorList2 = generateExerciseInstructor(3, lecture2);
        List<ExerciseInstructor> exerciseInstructorList3 = generateExerciseInstructor(9, lecture3);
        List<Lecture> lectures = new ArrayList<>();
//        System.out.println(lectureHall2.getRows());
        lectureHall2.placeStudents(studentList1);
//        exerciseInstructorList1.get(0).attend(lecture1);
//        exerciseInstructorList1.get(0).attend(lecture1);
        lectures.add(lecture1);
        lectures.add(lecture2);
        lectures.add(lecture3);
    }

    private static List<Student> generateStudents(int amount){
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            studentList.add(new Student("Student", Integer.toString(i + 1), generateTumID()));
        }
        return studentList;
    }

    private static String generateTumID() {

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

    private static List<Tutor> generateTutors(int amount,Lecture lecture){
        List<Tutor> tutorList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            tutorList.add(new Tutor("Tutor", Integer.toString(i), generateTumID(), lecture));
        }
        return tutorList;
    }

    private static List<ExerciseInstructor> generateExerciseInstructor(int amount,Lecture lecture){
        List<ExerciseInstructor> exerciseInstructorList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            exerciseInstructorList.add(new ExerciseInstructor("ExerciseInstructor", Integer.toString(i), generateTumID(), lecture));
        }
        return exerciseInstructorList;
    }
}
