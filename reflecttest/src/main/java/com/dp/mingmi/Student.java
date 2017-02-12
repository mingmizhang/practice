package com.dp.mingmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhangmingmi on 16/10/10.
 */
public class Student {
    private static final Logger logger = LoggerFactory.getLogger(Student.class);
    public String name;
    public int age;
    public float score;

    public Student(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    public Student() {
    }
}
