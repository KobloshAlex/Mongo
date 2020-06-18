package com.cogent.info;

import com.cogent.info.connection.MongoConnection;
import com.cogent.info.dao.impl.StudentDao;
import com.cogent.info.entities.Course;
import com.cogent.info.entities.Student;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static java.util.Collections.singletonList;

public class Main {

    public static void main(String[] args) {
        MongoConnection mongoConnection = new MongoConnection();

        try (MongoClient mongoClient = MongoClients.create(mongoConnection.getMongoClient())) {

            MongoDatabase db = mongoClient.getDatabase("cogent");

            MongoCollection<Student> studentsCollection = db.getCollection("students", Student.class);

            studentsCollection.deleteMany(new Document());
            Student student = new Student().setStudentId(2)
                                           .setFirstName("Alexx")
                                           .setLastName("Koblosh")
                                           .setEmail("alex@gmial.com")
                                           .setBalance(1000)
                                           .setPassword("1123").setCourses(singletonList(new Course().setId(1)
                                                                                                     .setCode(101)
                                                                                                     .setName("Math")));

            StudentDao studentDao = new StudentDao(studentsCollection);
            studentDao.save(student);

            //update
            student.setBalance(4000);
            studentDao.update(student);

        }
    }
}
