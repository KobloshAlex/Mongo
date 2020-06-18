package com.cogent.info;

import com.cogent.info.connection.MongoConnection;
import com.cogent.info.controller.Controller;
import com.cogent.info.dao.impl.CourseDao;
import com.cogent.info.dao.impl.StudentDao;
import com.cogent.info.entities.Course;
import com.cogent.info.entities.Student;
import com.cogent.info.view.ConsoleViewProvider;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String DB = "cogent";
    private static final String COURSES_COLLECTION = "courses";
    private static final String STUDENTS_COLLECTION = "students";

    public static void main(String[] args) {
        MongoConnection mongoConnection = new MongoConnection();

        try (MongoClient mongoClient = MongoClients.create(mongoConnection.getMongoClient())) {

            MongoDatabase db = mongoClient.getDatabase(DB);

            final CourseDao courseDao = new CourseDao(db.getCollection(COURSES_COLLECTION, Course.class));
            final StudentDao studentDao = new StudentDao(db.getCollection(STUDENTS_COLLECTION, Student.class));
            final ConsoleViewProvider viewProvider = new ConsoleViewProvider(new Scanner(System.in));
            final Controller controller = new Controller(studentDao, courseDao, viewProvider);

//            final List<Student> student = studentDao.findById(2);
//
//            for (Student iter : student) {
//                studentDao.update(iter.setCourses(courseDao.findById(1)));
//            }

             controller.callMenu();

        }
    }
}
