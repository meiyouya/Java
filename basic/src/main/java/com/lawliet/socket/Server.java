package com.lawliet.socket;

import java.net.ServerSocket;

/**
 * @author dell
 */
public class Server {

    public static void main(String[] args) {
        /*try {
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket client = serverSocket.accept();
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String userIn;
            while ((userIn = in.readLine()) != null) {
                System.out.println("用户：" + userIn);
                //发回客户端
                out.println("你好，" + userIn.replace("您好，我叫", "") + " 欢迎您");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        // 定义可接受多个客户端连接的socket
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            while (true) {
                Thread thread = new Thread(new ServerThread(serverSocket.accept()));
                thread.start();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
