package com.zql.myclient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class MyRedisClient {
    private Socket socket;
    private OutputStream outputStream;
    private InputStream inputStream;

    public MyRedisClient(String host, int port) {
        try {
            this.socket = new Socket(host, port);
            this.outputStream = this.socket.getOutputStream();
            this.inputStream = this.socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String auth(String password) {
        final StringBuilder sb = new StringBuilder();
        final String lineSeparator = System.lineSeparator();
        sb.append("*2").append(lineSeparator)
                .append("$4").append(lineSeparator)
                .append("AUTH").append(lineSeparator)
                .append("$").append(password.length()).append(lineSeparator)
                .append(password).append(lineSeparator);
        return sendCommand(sb.toString());
    }

    public String set(final String key, String value) {
        final StringBuilder sb = new StringBuilder();
        final String lineSeparator = System.lineSeparator();
        sb.append("*3").append(lineSeparator)
                .append("$3").append(lineSeparator)
                .append("SET").append(lineSeparator)
                .append("$").append(key.length()).append(lineSeparator)
                .append(key).append(lineSeparator)
                .append("$").append(value.length()).append(lineSeparator)
                .append(value).append(lineSeparator);
        return sendCommand(sb.toString());
    }

    private String sendCommand(String command) {
        final byte[] bytes = new byte[1024];
        try {
            outputStream.write(command.getBytes(StandardCharsets.UTF_8));
            inputStream.read(bytes);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }

    public static void main(String[] args) {
        final MyRedisClient client = new MyRedisClient("192.168.174.188", 6379);
        final String auth = client.auth("lawliet");
        System.out.println(auth);
        final String result = client.set("a", "b");
        System.out.println(result);
    }
}
