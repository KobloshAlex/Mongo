package com.cogent.info.dao.impl;

import com.cogent.info.dao.Crud;
import com.cogent.info.models.Student;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class StudentDao implements Crud<Student, Integer> {

    private final MongoCollection<Student> collection;

    public StudentDao(MongoCollection<Student> collection) {
        this.collection = collection;
    }

    @Override
    public void save(Student student) {
        collection.insertOne(student);
    }

    @Override
    public List<Student> findAll() {
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public List<Student> findById(Integer id) {
        return collection.find(Filters.eq("studentId", id)).into(new ArrayList<>());
    }

    @Override
    public void update(Student student) {
        collection.replaceOne(Filters.eq("studentId", student.getStudentId()), student);
    }

    @Override
    public void deleteById(Integer id) {
        collection.deleteOne(new Document("studentId", id));
    }

}
