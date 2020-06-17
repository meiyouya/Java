package com.lawliet.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 服务端线程
 * @author dell
 */
public class ServerThread implements Runnable{

    Socket client;

    public ServerThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String userIn;
            while ((userIn = in.readLine()) != null) {
                System.out.println("收到客户端消息：" + userIn);
                //发回客户端
                out.println(userIn);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
