package com.dp.mingmi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by zhangmingmi on 17/2/8.
 */
public class MiPersonOwn implements Serializable {
    private static final long serialVersionUID = 12346L;
    private String name;
    private int age;
    transient private String sex;

    public MiPersonOwn(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public MiPersonOwn() {
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
        return "MiPersonOwn{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }


    public void writeObject(ObjectOutputStream objectOutputStream){
        try {
            objectOutputStream.writeUTF(name);
            //objectOutputStream.writeInt(age);
            objectOutputStream.writeUTF(sex);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MiPersonOwn readObject(ObjectInputStream objectInputStream){
        MiPersonOwn miPersonOwn= new MiPersonOwn();
        try {
            miPersonOwn.name=objectInputStream.readUTF();
            //miPersonOwn.age=objectInputStream.readInt();
            miPersonOwn.sex=objectInputStream.readUTF();
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return miPersonOwn;
    }
}
