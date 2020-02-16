package com.thoughtworks.module;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String name;
    private ArrayList<Student> students;

    public Teacher() {
    }

    public Teacher(String name, ArrayList<Student> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Student> recheck() {
        //遍历，不重复的放入ids1，重复的id，如果ids2中不存在，放入ids2
        List<String> ids1 = new ArrayList<>();
        List<String> ids2 = new ArrayList<>();
        for (int i = 0; i < this.students.size(); i++) {
            String stuId = students.get(i).getId();
            if (ids1.contains(stuId)) {
                if (!ids2.contains(stuId)) {
                    ids2.add(stuId);
                }
            } else {
                ids1.add(stuId);
            }
        }

        //返回重复的学生
        List<Student> res = new ArrayList<>();
        for (int i = 0; i < this.students.size(); i++) {
            String stuId = students.get(i).getId();
            if (ids2.contains(stuId)) {
                res.add(students.get(i));
            }
        }
        return (ArrayList<Student>) res;
    }
}
