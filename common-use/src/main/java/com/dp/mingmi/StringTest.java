package com.dp.mingmi;

/**
 * Created by zhangmingmi on 17/2/10.
 */
public class StringTest {

    public static void main(String[] args){
        System.out.println(test1("mingmi.zhang"));

    }
    public static String test1(String string){
        int length=string.length();
        System.out.println(length);
        String tmp="";
        for(int i=length-1;i>0;i--){
            tmp=tmp+string.charAt(i);
        }
        return tmp;
    }
}
