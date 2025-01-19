package com.example.pair.pair.controller;


import javafx.util.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class PairController {

    @GetMapping("/pair")
    public Pair<String,Integer> returnPair() {
        Pair<String,Integer> pair = new Pair<>("test",3);
        return pair;
    }

    @GetMapping("/hashmap")
    public Map<String,Integer> returnHashMap() {
        Map<String,Integer> map  = new HashMap<>();
        map.put("test",3);
        map.put("test-1",4);
        map.put("test-2",5);
        map.put("test-3",6);
        map.put("test-4",7);
        return map;
    }

    @GetMapping("/complexstreamexample")
    public List<String> returnString()  {
        List<Person> p = new ArrayList<>();
        p.add(new Person("adam",3));
        p.add(new Person("tom",4));
        p.add(new Person("jim",33));
        p.add(new Person("ram",67));
        p.add(new Person("kendrick lamar",82));

        return p.stream().filter(p1 -> {
            if (p1.getAge() > 3) {

                return true;
            }else {
                return false;
            }
        }).map(lo -> {
            //if (lo.getName().equals("tom")) {
            //    try {
            //        throw new Exception("what went wrong?");
            //    } catch (Exception e) {
            //        throw new RuntimeException(e);
            //    }
            //}

            return lo.getName().toUpperCase();
        }).map(String::toLowerCase).collect(Collectors.toList());
    }

    @GetMapping("/getPairSchStudentsGrades")
    public Pair<School,Map<Student, Set<GradeSubject>>> doSomething() {
        School school  = new School();
        school.setSchoolName("ngee ann");
        school.setAddress("2C Kee Sun Avenue");

        Map<Student,Set<GradeSubject>> map = new HashMap<>();

        Student student = new Student();
        student.setId(23L);
        student.setName("nish");

        Student student1 = new Student();
        student1.setId(27L);
        student1.setName("prayag");

        Set<GradeSubject> nishGradeSubjectSet1 = new HashSet<>();
        Set<GradeSubject> nishGradeSubjectSet2 = new HashSet<>();

        GradeSubject gradeSubject = new GradeSubject();
        gradeSubject.setSubject("science");
        gradeSubject.setGradeScore(67L);

        GradeSubject gradeSubject1 = new GradeSubject();
        gradeSubject1.setSubject("maths");
        gradeSubject1.setGradeScore(33L);

        GradeSubject gradeSubject2 = new GradeSubject();
        gradeSubject2.setSubject("science");
        gradeSubject2.setGradeScore(83L);

        GradeSubject gradeSubject3 = new GradeSubject();
        gradeSubject3.setSubject("maths");
        gradeSubject3.setGradeScore(103L);

        nishGradeSubjectSet1.add(gradeSubject);
        nishGradeSubjectSet1.add(gradeSubject1);

        nishGradeSubjectSet2.add(gradeSubject2);
        nishGradeSubjectSet2.add(gradeSubject3);

        map.put(student,nishGradeSubjectSet1);
        map.put(student1,nishGradeSubjectSet2);

        Pair<School, Map<Student,Set<GradeSubject>>> x = new Pair<>(school,map);

        Map<Student, Set<GradeSubject>> value = x.getValue();

        return x;

    }
}

class School {
    private String schoolName;
    private String address;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

class Student {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class GradeSubject {
    private long gradeScore;
    private String subject;

    public long getGradeScore() {
        return gradeScore;
    }

    public void setGradeScore(long gradeScore) {
        this.gradeScore = gradeScore;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
