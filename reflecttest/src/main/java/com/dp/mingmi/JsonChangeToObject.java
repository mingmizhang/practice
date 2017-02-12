package com.dp.mingmi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by zhangmingmi on 16/10/12.
 */
public class JsonChangeToObject {
    private static final Logger logger = LoggerFactory.getLogger(JsonChangeToObject.class);
    private List<String> fieldsName = new ArrayList<String>();
    private String str;
    private Class className;

    public JsonChangeToObject(String str, Class className) {
        this.str = str;
        this.className = className;
    }

    public List<String> getFieldsNameFromJson() {
        JSONObject jsonObject = JSON.parseObject(str);
        List<String> JsonfieldsName = new ArrayList<String>();
        Set keySet = jsonObject.keySet();
        for (Iterator iterator = keySet.iterator(); iterator.hasNext(); ) {
            String test = (String) iterator.next();
            JsonfieldsName.add(test);
        }
        return JsonfieldsName;
    }


    public List<String> getFields() {
        Field[] fields = className.getFields();
        for (int i = 0; i < fields.length; i++) {
            fieldsName.add(fields[i].getName());
        }
        return fieldsName;
    }

    public Class[] getFieldsType() {
        try {
            Class[] fieldsType = new Class[fieldsName.size()];
            for (int i = 0; i < fieldsName.size(); i++) {
                Field field = className.getField(fieldsName.get(i));
                fieldsType[i] = field.getType();
            }
            return fieldsType;
        } catch (NoSuchFieldException e) {
            logger.error("NoSuchFieldException {}", e);
            return null;
        }
    }


    public Object createObjectByConstructor(Class[] paraClass) {
        try {
            Constructor constructor = className.getDeclaredConstructor(paraClass);
            Object obj = constructor.newInstance();
            return obj;
        } catch (NoSuchMethodException e) {
            logger.error("Exception {}", e);
            return null;
        } catch (IllegalAccessException e) {
            logger.error("Exception {}", e);
            return null;
        } catch (InvocationTargetException e) {
            logger.error("Exception {}", e);
            return null;
        } catch (InstantiationException e) {
            logger.error("Exception {}", e);
            return null;
        }
    }


    public static void main(String[] args) {
        String str = "{\"name\":\"mingmi.zhang\",\"age\":30,\"score\":99.9,\"teacherList\":[{\"teacherName\":\"mmm\",\"teacherAge\":20,\"Status\":1}]}";
        JsonChangeToObject jsonChangeToObject = new JsonChangeToObject(str, StudentListTest.class);
        jsonChangeToObject.getFields();
        Class[] className = jsonChangeToObject.getFieldsType();
        Object object = jsonChangeToObject.createObjectByConstructor(null);
        logger.info("The end");


    }


}
