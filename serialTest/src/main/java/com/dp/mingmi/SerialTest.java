package com.dp.mingmi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangmingmi on 17/2/8.
 */
public class SerialTest {
    public static void main(String[] args) {
        //testOriginalSerial();
        testOwnSerial();
    }

    public static void testOwnSerial() {
        File file = new File("/Users/zhangmingmi/Desktop/MiPersonOwn.info");
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            MiPersonOwn miPersonOwn = new MiPersonOwn("mingmi.zhang", 19, "男");
            miPersonOwn.writeObject(objectOutputStream);
            ObjectInputStream objectInputStream = null;
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            MiPersonOwn miPersonOwnTest = MiPersonOwn.readObject(objectInputStream);
            System.out.println(miPersonOwnTest);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }


    }

    public static void testOriginalSerial() {
        File file = new File("/Users/zhangmingmi/Desktop/MiPerson.info");
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            MiPerson miPerson1 = new MiPerson();
            MiPerson miPerson2 = new MiPerson("mingmi", 18, "女");
            List<MiPerson> miPersonList = new ArrayList<MiPerson>();
            miPersonList.add(miPerson1);
            miPersonList.add(miPerson2);
            objectOutputStream.writeObject(miPerson1);
            objectOutputStream.writeObject(miPerson2);
            objectOutputStream.writeObject(miPersonList);
            objectOutputStream.close();
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Object obj = objectInputStream.readObject();
            Object obj2 = objectInputStream.readObject();
            Object obj3 = objectInputStream.readObject();
            List<Object> list3 = (List) obj3;
            System.out.println(obj);
            System.out.println(obj2);
            System.out.println(obj3);
            System.out.println(list3.get(0));
            System.out.println(list3.get(1));
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
