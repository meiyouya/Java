package com.zql.base64;

import java.io.UnsupportedEncodingException;
import java.security.spec.ECField;
import java.util.Base64;

public class Base64Class {

    public static void main(String[] args) {

        try {
            // 基本编码
            String encodeToString = Base64.getEncoder().encodeToString("runoob?java8".getBytes("utf-8"));
            System.out.println(encodeToString);
            // 基本解码
            byte[] decodeBytes = Base64.getDecoder().decode(encodeToString);
            String decodeString = new String(decodeBytes, "utf-8");
            System.out.println(decodeString);

            // URL编码
            String urlEncodeString = Base64.getUrlEncoder().encodeToString("TutorialsPoint?java8".getBytes("utf-8"));
            System.out.println(urlEncodeString);
            // URL解码
            byte[] urlDecodeBytes = Base64.getUrlDecoder().decode(urlEncodeString);
            String urlDecodeString = new String(urlDecodeBytes, "utf-8");
            System.out.println(urlDecodeString);

            // MIME类似
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
