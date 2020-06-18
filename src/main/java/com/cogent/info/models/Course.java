package com.cogent.info.models;

import java.util.List;

public class Course {

    private Integer courseId;
    private Integer code;
    private String name;
    private List<Student> students;

    public Integer getCourseId() {
        return courseId;
    }

    public Course setCourseId(Integer courseId) {
        this.courseId = courseId;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public Course setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }


    public List<Student> getStudents() {
        return students;
    }

    public Course setStudents(List<Student> students) {
        this.students = students;
        return this;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
