package com.dp.mingmi;

/**
 * Created by zhangmingmi on 17/2/9.
 */
public class MiThreadPool implements Runnable {
    private String name;
    public void run(){
        for(int i=0;i<20;i++){
            System.out.println("mingmi.zhang"+i);
        }


    }
}
