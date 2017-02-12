package com.dp.mingmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * Created by zhangmingmi on 17/1/5.
 */
public class StringChange {
    private static final Logger logger = LoggerFactory.getLogger(StringChange.class);
    public static void main(String[] args){
        String testStr="Hello China";
        String destStr="Hello Kitty";
        Class className=testStr.getClass();
        logger.info(className.toString());
        try {
            logger.info(testStr);
            Field field = className.getDeclaredField("value");
            field.setAccessible(true);
            Object valueOriginal = field.get(testStr);
            char[] io = (char[]) valueOriginal;
            io[6]='K';
            logger.info(field.toString());
            logger.info(testStr);
        }catch(Exception e){
            System.out.println("hh"+e);
        }


    }
}
