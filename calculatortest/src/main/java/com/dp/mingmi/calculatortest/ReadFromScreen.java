package com.dp.mingmi.calculatortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zhangmingmi on 16/9/12.
 */
public class ReadFromScreen {
    public  String readlinefromscreen() throws IOException
    {
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Please input the expression you want to input ~~~.");
        //do {
            str = br.readLine();
            System.out.println("The expression you input is: "+str);
            //System.out.println("The expression you input is: "+str.charAt(0));
        //} while(!str.equals("exit"));
        return str;
    }
    public static void main(String[] args) throws IOException {
        //读取输入的计算表达式
        ReadFromScreen readstring =  new ReadFromScreen();
        readstring.readlinefromscreen();
        //
    }

}
