package com.dp.mingmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhangmingmi on 16/10/12.
 */
public class StudentTeacher {
    private static final Logger logger = LoggerFactory.getLogger(StudentTeacher.class);
    public String name;
    public int age;
    public float score;
    Teacher teacher;

    public StudentTeacher(String name, int age, float score, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.teacher = teacher;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "StudentTeacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", teacher=" + teacher +
                '}';
    }
}
