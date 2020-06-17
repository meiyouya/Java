package com.lawliet.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author dell
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 1234);
        // 获取socket输出流
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        String username;
        //获取输入流
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的用户名（输入q退出）：");
        while (!"q".equalsIgnoreCase(username = scanner.nextLine())) {
            out.println("您好，我叫" + username);
            System.out.println("服务器：" + in.readLine());
        }
        socket.close();
    }
}
