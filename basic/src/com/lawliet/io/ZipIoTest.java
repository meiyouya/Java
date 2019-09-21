package com.lawliet.io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipIoTest {

    public static void main(String[] args) throws IOException {
        zip("hello.zip",new File("E:\\projects\\idea_work\\Java\\basic"));
    }

    private static void zip(String filename, File file) throws IOException {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(filename));
        executeZip(zipOutputStream,file,"");
        System.out.println("压缩中...");
        zipOutputStream.close();
    }

    private static void executeZip(ZipOutputStream out, File f, String base) throws IOException {
        if (f.isDirectory()) {
            File[] fileList = f.listFiles();
            if (base.length() != 0) {
                out.putNextEntry(new ZipEntry(base + "/"));
            }
            for (File file : fileList) {
                executeZip(out,file,base + file);
            }
        } else {
            out.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(f);
            int b;
            System.out.println(base);
            while ((b = in.read()) != -1) {
                out.write(b);
            }
            in.close();
        }
    }
}
