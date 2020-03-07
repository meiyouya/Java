package com.zql.test;

import com.zql.utils.zxing.ZxingCode;

public class TestQRCode {
    public static void main(String[] args) {
        String text = "http://www.lawliet.online:8080/study/";
        String imagePath = "C:\\Users\\没有牙\\Desktop\\zixing\\二维码.png";
        String logoPath = "C:\\Users\\没有牙\\Desktop\\zixing\\logo.jpg";
        ZxingCode.encodeQRCodeImage(text,null,imagePath,800,800,logoPath);

//        System.out.println(ZxingCode.decodeQRCodeImage("C:\\Users\\没有牙\\Desktop\\zixing\\二维码.png","UTF-8"));
    }
}
