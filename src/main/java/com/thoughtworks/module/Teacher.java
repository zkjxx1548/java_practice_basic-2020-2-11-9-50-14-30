package com.thoughtworks.module;

import java.util.ArrayList;
import java.util.HashMap;

public class Teacher {
    private String name;
    private ArrayList<Student> students = new ArrayList<>();

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



    public HashMap<String, ArrayList<Student>> recheck() {
        HashMap<String, ArrayList<Student>> map = new HashMap<>();
        for (int i = 0; i < this.students.size(); i++) {
            String stuId = students.get(i).getId();
            ArrayList<Student> idList = new ArrayList<>();
            if (map.containsKey(stuId)) {
                idList = map.get(stuId);
            }
            idList.add(students.get(i));
            map.put(stuId, idList);
        }

        HashMap<String, ArrayList<Student>> mapRecheck = new HashMap<>();
        for (HashMap.Entry<String, ArrayList<Student>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                mapRecheck.put(entry.getKey(), entry.getValue());
            }
        }
        return mapRecheck;
    }
}
