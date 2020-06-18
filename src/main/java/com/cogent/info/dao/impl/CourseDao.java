package com.cogent.info.dao.impl;

import com.cogent.info.dao.Crud;
import com.cogent.info.entities.Course;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class CourseDao implements Crud<Course, Integer> {

    private final MongoCollection<Course> collection;

    public CourseDao(MongoCollection<Course> collection) {
        this.collection = collection;
    }

    @Override
    public void save(Course course) {
        collection.insertOne(course);
    }

    @Override
    public List<Course> findAll() {
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public List<Course> findById(Integer id) {
        return collection.find(Filters.eq("courseId", id)).into(new ArrayList<>());
    }

    @Override
    public void update(Course course) {
        collection.replaceOne(Filters.eq("courseId", course.getCourseId()), course);
    }

    @Override
    public void deleteById(Integer id) {
        collection.deleteOne(new Document("courseId", id));
    }
}
