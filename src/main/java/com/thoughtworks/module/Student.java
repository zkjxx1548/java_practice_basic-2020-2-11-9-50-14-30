package com.thoughtworks.module;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Student {
    private String name;
    private String id;
    private String admissionDate;

    public Student() {
    }

    public Student(String name, String id, String admissionDate) {
        this.name = name;
        this.id = id;
        this.admissionDate = admissionDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        long nowTime = System.currentTimeMillis();
        long timeDiff = 0;
        try {
            timeDiff = nowTime - sdf.parse(this.admissionDate).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int schoolAge = (int) (timeDiff / 3.1536e10 + 1);
        return String.format("我叫%s，我的学号是%s，%s入学，学龄%d年", this.name, this.id, this.admissionDate, schoolAge);
    }
}
