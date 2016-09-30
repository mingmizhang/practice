package com.dp.mingmi.calculatortest;

import java.io.*;

/**
 * Created by zhangmingmi on 16/9/19.
 */
public class StreamTest {

    public static void main(String args[]) throws IOException {
//        System.out.println("hha");
//        OutputStream outputStream = new FileOutputStream("/Users/zhangmingmi");
//        InputStream inputStream = new FileInputStream("/Users/zhangmingmi/playbook.retry");
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
//        bufferedInputStream.read(new byte[]);
//        FileReader fileReader = new FileReader("Users/zhangmingmi/playbook.retry");
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s = "test";
        StringReader stringReader =  new StringReader(s);
        int len = 0;
        char[] chars = new char[2];
        while ((len = stringReader.read(chars)) != -1) {
            String strRead = new String(chars, 0, len);
            System.out.println(strRead);

        }



    }
}
