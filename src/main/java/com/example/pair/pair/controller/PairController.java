package com.example.pair.pair.controller;


import javafx.util.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
