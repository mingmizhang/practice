package com.dp.mingmi;

import java.io.*;
import java.net.Socket;

/**
 * Created by zhangmingmi on 16/9/5.
 */
public class TaskSocket implements Runnable {
    private Socket socket;
    public static volatile int number=0;

    public TaskSocket(Socket socket) {
        this.socket = socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            number=number+1;
            //读入client端的数据
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuilder sb = new StringBuilder();
            int index;
            String test;
            while ((test = br.readLine()) != null) {
                if ((index = test.indexOf("eof")) != -1) {
                    break;
                }
                sb.append(test + " ");
            }
            System.out.println("XXX Says: " + sb);
            //向client发送返回的数据
            Writer writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write("XXX,\n");
            writer.write("you are right!!!\n");
            writer.write("eof\n");
            writer.flush();
            //Thread.sleep(1000);
            System.out.println("the thread number is: "+ number);
            //关闭
            br.close();
            writer.close();
            socket.close();
        } catch (
                Exception e
                )

        {
            e.printStackTrace();
        }

    }
}
