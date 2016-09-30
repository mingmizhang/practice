package com.dp.mingmi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhangmingmi on 16/9/5.
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        int port = 8899;
        //定义一个ServerSocket监听在端口8899上
        ServerSocket server = new ServerSocket(port);
        //server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的
        Socket socket = server.accept();
        //读入client端的数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        StringBuilder sb = new StringBuilder();
        int index;
        String test;
        while ((test=br.readLine())!= null) {
            if((index = test.indexOf("eof")) != -1){
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

        //再次接收客户端传回的数据
        sb.delete(0,sb.length());
        while ((test=br.readLine())!= null) {
            //System.out.println(test);
            if((index = test.indexOf("eof")) != -1){
                break;
            }
            sb.append(test + " ");
        }
        System.out.println("XXX alsoSays: " + sb);

        //关闭
        br.close();
        writer.close();
        socket.close();
        server.close();
    }
}
