package com.cogent.info.controller;

import com.cogent.info.dao.impl.CourseDao;
import com.cogent.info.dao.impl.StudentDao;
import com.cogent.info.entities.Course;
import com.cogent.info.entities.Student;
import com.cogent.info.view.ConsoleViewProvider;

import java.util.List;

import static java.util.Collections.singletonList;

public class Controller {

    private final StudentDao studentDao;
    private final CourseDao courseDao;
    private final ConsoleViewProvider viewProvider;

    public Controller(StudentDao studentDao, CourseDao courseDao, ConsoleViewProvider viewProvider) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
        this.viewProvider = viewProvider;
    }

    public void callMenu() {
        while (true) {
            viewProvider.printMenu();
            String choice = viewProvider.readString();

            switch (choice) {
                case "1":
                    printAllStudents();
                    break;
                case "2":
                    findStudentById();
                    break;
                case "3":
                    enrollStudentToCourse();
                    break;
                case "x":
                    System.exit(0);
                    break;
                default:
                    printDefault();
                    break;
            }
        }
    }

    private void printAllStudents() {
        viewProvider.printMessage("List of all students: ");
        viewProvider.printStudentsFormat(studentDao.findAll());
    }

    private void findStudentById() {
        viewProvider.printMessage("Enter Student ID: ");
        Integer studentId = getId();
        viewProvider.printStudentsFormat(studentDao.findById(studentId));
    }

    private void enrollStudentToCourse() {
        viewProvider.printMessage("List of all students: ");
        viewProvider.printStudentsFormat(studentDao.findAll());
        Integer studentId = getId();
        final List<Student> student = studentDao.findById(studentId);
        viewProvider.printMessage("Select course by ID: ");
        viewProvider.printCoursesFormat(courseDao.findAll());
        Integer courseId = getId();
        final List<Course> course = courseDao.findById(courseId);
        //assign new student to course
        Course courseToAdd = new Course();
        for (Course iteratedCourse : course) {
            courseToAdd.setCourseId(iteratedCourse.getCourseId())
                       .setName(iteratedCourse.getName())
                       .setCode(iteratedCourse.getCode());
            courseDao.update(iteratedCourse.setStudents(student));
        }
        //add course to student record
        for (Student iteratorStudent : student) {
            studentDao.update(iteratorStudent.setCourses(singletonList(courseToAdd)));
        }

    }

    private void printDefault() {
        viewProvider.printMessage("Please enter only numbers from 1 to 3");
    }

    private int getId() {
        return Integer.parseInt(viewProvider.readString());
    }

}
