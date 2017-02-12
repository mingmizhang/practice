package com.dp.mingmi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by zhangmingmi on 16/10/9.
 */
public class ReadInputFromKeyboard {
    public  String readLineFromKeyboard()
    {
        String str="";
        try {
            // 使用 System.in 创建 BufferedReader
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            str = br.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }
        return str;
    }
}
