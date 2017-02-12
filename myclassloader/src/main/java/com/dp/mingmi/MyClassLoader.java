package com.dp.mingmi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Method;

/**
 * Created by zhangmingmi on 16/12/22.
 */
public class MyClassLoader extends ClassLoader {
    private static final Logger logger = LoggerFactory.getLogger(MyClassLoader.class);
    private String MyClassLoaderRootPath="/Users/zhangmingmi/Desktop/code_project/";
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPathName = MyClassLoaderRootPath+name.replace('.', '/') + ".class";
        logger.info("The class's wholeName is: ", classPathName);
        File classFile = new File(classPathName);
        InputStream inputStream = null;
        int out = 0;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            inputStream=new FileInputStream(classFile);
            while ((out = inputStream.read()) != -1) {
                outputStream.write(out);
            }
            outputStream.flush();
            byte b[] = outputStream.toByteArray();
            return defineClass(name, b, 0, b.length);
        } catch (Exception e) {
            logger.error("error exception" + e);
        } finally {
            try {
                if (outputStream != null)
                    outputStream.close();
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e1) {
            }
        }
        return null;
    }
    public static void main(String[] args){
        MyClassLoader myClassLoader=new MyClassLoader();
        logger.info(MyClassLoader.class.getClassLoader().toString());
        try {
            Class helloWorldClass = myClassLoader.loadClass("com.dp.mingmi.HelloWorld");
            Object obj=helloWorldClass.newInstance();
            Method m1=helloWorldClass.getDeclaredMethod("printHello");
            m1.invoke(obj);
            logger.info(helloWorldClass.getClassLoader().toString());
        }catch(Exception c){
            logger.error("Load class by own classloader ERROR" + c);
        }


    }
}
