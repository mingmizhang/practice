package com.dp.mingmi;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangmingmi on 16/10/10.
 */
public class ReflectUtils  {
    private static final Logger logger = LoggerFactory.getLogger(ReflectUtils.class);
    private Class className;
    private String str;
    private List<String> fieldsName = new ArrayList<String>();
    private Map<String, String> fieldInfo = new HashMap<String, String>();

    private Map<String, String> parseFieldNameFromString(String inputString) {
        String[] fileds = StringUtils.split(StringUtils.strip(inputString, "{|}"), ",     ");
        String[] singleFieldInfo;
        for (int i = 0; i < fileds.length; i++) {
            singleFieldInfo = StringUtils.split(fileds[i], ":");
            fieldsName.add(StringUtils.strip(singleFieldInfo[0], "\""));
            fieldInfo.put(StringUtils.strip(singleFieldInfo[0], "\""), StringUtils.strip(singleFieldInfo[1], "\""));
        }
        return fieldInfo;
    }

    private Class findClassType(String className) {
        try {
            this.className = Class.forName(className);
            return this.className;
        } catch (ClassNotFoundException e) {
            logger.error("ClassNotFoundException {}", e);
            return null;
        }
    }


    public ReflectUtils(String className, String str) {
        this.className = findClassType(className);
        this.str = str;
        parseFieldNameFromString(str);
    }

    public ReflectUtils(Class className, String str) {
        //this.className = findClassType(className);
        this.className = className;
        this.str = str;
        parseFieldNameFromString(str);
    }

    private Class[] getFieldsType() {
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

    private Class getFieldType(String name) {
        try {

            Field field = className.getField(name);
            Class fieldType = field.getType();
            return fieldType;
        } catch (NoSuchFieldException e) {
            logger.error("NoSuchFieldException {}", e);
            return null;
        }
    }

    private Object setStringFieldValue(String fieldName, Object object, String fieldNameValue) {
        try {
            Method getMethod = className.getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length()));
            String filedNameOriginalValue = (String) getMethod.invoke(object);
            Method setMethod = className.getDeclaredMethod("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length()), fieldNameValue.getClass());
            setMethod.invoke(object, fieldNameValue);
            return object;
        } catch (NoSuchMethodException e) {
            logger.error("Exception {}", e);
            return null;
        } catch (IllegalAccessException e) {
            logger.error("Exception {}", e);
            return null;
        } catch (InvocationTargetException e) {
            logger.error("Exception {}", e);
            return null;
        }
    }

    private Object setIntFieldValue(String fieldName, Object object, int fieldNameValue) {
        try {
            Method getMethod = className.getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length()));
            Object filedNameOriginalValue = (Object) getMethod.invoke(object);
            Method setMethod = className.getDeclaredMethod("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length()), int.class);
            setMethod.invoke(object, fieldNameValue);
            return object;
        } catch (NoSuchMethodException e) {
            logger.error("Exception {}", e);
            return null;
        } catch (IllegalAccessException e) {
            logger.error("Exception {}", e);
            return null;
        } catch (InvocationTargetException e) {
            logger.error("Exception {}", e);
            return null;
        }
    }

    private Object setFloatFieldValue(String fieldName, Object object, float fieldNameValue) {
        try {
            Method getMethod = className.getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length()));
            Object filedNameOriginalValue = getMethod.invoke(object);
            Method setMethod = className.getDeclaredMethod("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length()), float.class);
            setMethod.invoke(object, fieldNameValue);
            return object;
        } catch (NoSuchMethodException e) {
            logger.error("Exception {}", e);
            return null;
        } catch (IllegalAccessException e) {
            logger.error("Exception {}", e);
            return null;
        } catch (InvocationTargetException e) {
            logger.error("Exception {}", e);
            return null;
        }
    }


    public Object setObjectValue(Object obj) {
        for (int i = 0; i < fieldsName.size(); i++) {
            String fieldValue = fieldInfo.get(fieldsName.get(i));
            String test = getFieldType(fieldsName.get(i)).getName();
            if (getFieldType(fieldsName.get(i)).getName().equals("java.lang.String")) {
                obj = setStringFieldValue(fieldsName.get(i), obj, fieldValue);
            } else if (getFieldType(fieldsName.get(i)).getName().equals("int")) {
                obj = setIntFieldValue(fieldsName.get(i), obj, Integer.valueOf(fieldValue));
            } else if (getFieldType(fieldsName.get(i)).getName().equals("float")) {
                obj = setFloatFieldValue(fieldsName.get(i), obj, Float.parseFloat(fieldValue));
            }

        }
        return obj;
    }


    public Object createObjectBySpecifiedConstructor(Class[] paraClass) {
        try {
            Constructor constructor = className.getDeclaredConstructor(paraClass);
            //           Object obj = constructor.newInstance("", 0, 0);
//            Constructor constructor = className.getDeclaredConstructor();
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

//    public Object createObjectByConstructor() {
//        try {
//            Constructor constructor = className.getConstructor();
//            Object obj = constructor.newInstance();
//            //Constructor constructor = className.getConstructor(String.class,int.class,float.class);
//            //Object obj = constructor.newInstance("1",2,3);
//            return obj;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }


    public static Object createObjectByString(Class className, String str) {
        ReflectUtils reflectUtils = new ReflectUtils(className, str);
        Object obj = reflectUtils.createObjectBySpecifiedConstructor(null);
        Object objAfterSet = reflectUtils.setObjectValue(obj);
        logger.info("obj {}", objAfterSet);
        return objAfterSet;
    }

}
