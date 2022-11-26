package de.tum.in.ase;

import java.util.*;

public class LectureHall {
    private String name;
    private int capacity;
    private int rows;
    private Student[][] rowsOfStudents;
    private final int MAX_STUDENT_PER_ROW = 30;

    public LectureHall(String name, int capacity) {
        this.name = name;
        if (capacity < 90) {
            this.capacity = 90;
        } else {
            this.capacity = capacity;
        }
        this.rows = this.capacity / MAX_STUDENT_PER_ROW;
        this.rowsOfStudents = new Student[this.rows][MAX_STUDENT_PER_ROW];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Student[][] getRowsOfStudents() {
        return rowsOfStudents;
    }

    public void setRowsOfStudents(Student[][] rowsOfStudents) {
        this.rowsOfStudents = rowsOfStudents;
    }

    public void placeStudents(List<Student> waitingStudents) {
//        prints out the size of the list to the console: "Waiting students: [number of waiting students]"
//Now it should be checked, if the amount of students is too big for the LectureHall
        System.out.printf("Waiting students: %d%n", waitingStudents.size());
        if (waitingStudents.size() > capacity) {
            System.out.printf("%s hall doesn't have enough places for all the students!%n", name);
            System.out.printf("We can place only the first %d out of %d students.%n", capacity, waitingStudents.size());
            if (waitingStudents.size() > 0) {
                int amountOfStudentFilled = 0;
                while (!waitingStudents.isEmpty() && amountOfStudentFilled < capacity) {
                    for (int row = 0; row < rows; row++) {
                        for (int col = 0; col < MAX_STUDENT_PER_ROW; col++) {
                            if (waitingStudents.isEmpty() || amountOfStudentFilled == capacity) {
                                break;
                            }
//                        System.out.println("current student in row:" + row + " col:" + col + " is " + rowsOfStudents[row][col]);
                            if (rowsOfStudents[row][col] == null) {
                                amountOfStudentFilled += 1;
                                rowsOfStudents[row][col] = waitingStudents.remove(0);
//                            System.out.println("row:" + row + " col:" + col + " ->" + rowsOfStudents[row][col]);
                            }
                        }
                    }
                }
            }
        } else {
            if (waitingStudents.size() > 0) {
                int amountOfStudentFilled = 0;
                while (!waitingStudents.isEmpty() && amountOfStudentFilled < capacity) {
                    for (int row = 0; row < rows; row++) {
                        for (int col = 0; col < MAX_STUDENT_PER_ROW; col++) {
                            if (waitingStudents.isEmpty() || amountOfStudentFilled == capacity) {
                                break;
                            }
    //                        System.out.println("current student in row:" + row + " col:" + col + " is " + rowsOfStudents[row][col]);
                            if (rowsOfStudents[row][col] == null) {
                                amountOfStudentFilled += 1;
                                rowsOfStudents[row][col] = waitingStudents.remove(0);
    //                            System.out.println("row:" + row + " col:" + col + " ->" + rowsOfStudents[row][col]);
                            }
                        }
                    }
                }
                System.out.printf("All students are sitting in the lecture hall.%n");
            }
        }
        System.out.println(toString());
    }

    public void empty() {
//         clean up the LectureHall and remove all Students from it
        this.rowsOfStudents = new Student[this.rows][MAX_STUDENT_PER_ROW];
    }

    public String toString() {
        String lectureHallName = String.format("%s hall:%n", name);
        String rowInfo = "";
        for (int row = 0; row < this.rows; row++) {
            rowInfo += String.format("Row %d: ", row + 1);
            for (int col = 0; col < MAX_STUDENT_PER_ROW; col++) {
                if (rowsOfStudents[row][col] != null) {
                    rowInfo += String.format("[%s]", rowsOfStudents[row][col].getName());
                } else {
                    rowInfo += "[]";
                }
            }
            if (row < this.rows - 1) {
                rowInfo += "\n";
            }
        }
        return lectureHallName + rowInfo;
    }
}
