package com.thoughtworks;

import com.thoughtworks.module.Student;
import com.thoughtworks.module.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {

  public static void main(String[] args) {
    Student student1 = new Student("张三", "001", "2019.02.11");
    Student student2 = new Student("李四", "002", "2019.02.10");
    Student student3 = new Student("王五", "001", "2019.02.09");
    List<Student> students = new ArrayList<>();
    students.add(student1);
    students.add(student2);
    students.add(student3);
    Teacher teacher = new Teacher("张龙", (ArrayList<Student>) students);

    printRecheckStudents(teacher, teacher.recheck());
  }

  public static void printRecheckStudents(Teacher teacher, HashMap<String, ArrayList<Student>> students) {
    System.out.println(String.format("教师%s名下的重复学生名单为：", teacher.getName()));
    for (HashMap.Entry<String, ArrayList<Student>> entry : students.entrySet()) {
      for (Student student : entry.getValue()) {
        System.out.println(student.toString());
      }
    }
  }
}
