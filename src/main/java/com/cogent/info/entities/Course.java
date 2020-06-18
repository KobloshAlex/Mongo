package com.cogent.info.entities;

public class Course {

    private Integer id;
    private Integer code;
    private String name;

    public Integer getId() {
        return id;
    }

    public Course setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
