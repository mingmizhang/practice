package com.dp.mingmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by zhangmingmi on 16/10/12.
 */
public class StudentListTest {
    private static final Logger logger = LoggerFactory.getLogger(StudentListTest.class);
    public String name;
    public int age;
    public float score;
    public List<Teacher> teacherList;

    public StudentListTest(String name, int age, float score,List<Teacher> teacherList) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.teacherList = teacherList;
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

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public String toString() {
        return "StudentListTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", teacherList=" + teacherList +
                '}';
    }

    public StudentListTest() {
    }
}

