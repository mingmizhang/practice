package com.dp.mingmi;

import java.io.*;
import java.net.Socket;

/**
 * Created by zhangmingmi on 16/9/5.
 */
public class SocketClient {
    public static void main(String[] args) throws IOException{
        //定义一个ServerSocket监听在端口8899上
        String host = "127.0.0.1";  //要连接的服务端IP地址
        int port = 8899;   //要连接的服务端对应的监听端口
        //与服务端建立连接
        Socket client = new Socket(host, port);
        //建立连接后就可以往服务端写数据了
        Writer writer = new OutputStreamWriter(client.getOutputStream());
        writer.write("hi, mingmi, \n");
        writer.write("You are such an excellent girl!!!\n");
        writer.write("eof\n");
        writer.flush();
        //接收服务端传回的数据
        BufferedReader cr = new BufferedReader(new InputStreamReader(client.getInputStream()));
        StringBuilder cb = new StringBuilder();
        int index;
        String test;
        while ((test=cr.readLine())!= null) {
            if((index = test.indexOf("eof")) != -1){
                break;
            }
            cb.append(test + " ");
        }
        System.out.println("Mingmi Says: " + cb);

        //再次向服务端发送数据
        writer.write("Oh, \n");
        writer.write("I am such an idiot!!!\n");
        writer.write("eof\n");
        writer.flush();

        //关闭
        cr.close();
        writer.close();
        client.close();
}
}
