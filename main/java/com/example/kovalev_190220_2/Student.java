package com.example.kovalev_190220_2;

public class Student {
    private String name;
    private String secondName;
    private Integer phone;

    public Student(String name, String secondName, Integer phone) {
        this.name = name;
        this.secondName = secondName;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public Integer getPhone() {
        return phone;
    }
}
