package com.dp.mingmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhangmingmi on 16/10/10.
 */
public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        ReflectUtils.createObjectByString(Student.class,"{\"name\":\"mingmi.zhang\",\"age\":30,\"score\":99.9}");
        //ReflectUtils.createObjectByString(Student.class,"{\"name\":\"mingmi.zhang\",\"age\":30,\"score\":99.9,\"teacher\":[{\"english\": \"zzz\"}]}");
    }

}
