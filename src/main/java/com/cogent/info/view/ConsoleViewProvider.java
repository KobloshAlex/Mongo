package com.cogent.info.view;

import com.cogent.info.models.Course;
import com.cogent.info.models.Student;

import java.util.List;
import java.util.Scanner;

public class ConsoleViewProvider {

    private static final String NEW_LINE = "\n";
    private static final String DELIMITER = " | ";
    private static final String MENU = "1 - Find all students" + NEW_LINE +
            "2 - Find Student by ID" + NEW_LINE +
            "3 - Enroll student to course" + NEW_LINE +
            "x - Exit";

    private final Scanner scanner;

    public ConsoleViewProvider(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMenu() {
        printMessage(MENU);
    }

    public String readString() {
        return scanner.next();
    }

    public void printStudentsFormat(List<Student> students) {
        students.forEach(student -> System.out.println("ID :" + student.getStudentId() + DELIMITER + "First name: " +
                student.getFirstName() + DELIMITER + "Last Name: " + student.getLastName() + DELIMITER +
                "Balance $: " + student.getBalance() + DELIMITER + "Email: " + student.getEmail()));
    }

    public void printCoursesFormat(List<Course> courses) {
        courses.forEach(course -> System.out.println("ID :" + course.getCourseId() + DELIMITER + "Code: " + course.getCode() +
                DELIMITER + "Course Name: " + course.getName()));
    }
}
