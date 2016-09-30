package com.dp.mingmi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhangmingmi on 16/9/5.
 */
public class SocketServerServeralThreads {
    public static void main(String[] args) throws IOException {
        int port = 8899;
        //定义一个ServerSocket监听在端口8899上
        ServerSocket server = new ServerSocket(port);
        //server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的
        while(true){
            Socket socket = server.accept();
            new Thread(new TaskSocket(socket)).start();

        }

    }
}
