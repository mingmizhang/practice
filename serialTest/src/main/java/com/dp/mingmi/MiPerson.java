package com.dp.mingmi;

import java.io.Serializable;

/**
 * Created by zhangmingmi on 17/2/8.
 */
public class MiPerson implements Serializable{
    private static final long serialVersionUID = 12345L;
    private String name;
    private int age;
    transient private String sex;

    public MiPerson(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public MiPerson() {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "MiPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
