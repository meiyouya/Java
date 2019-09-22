package com.lawliet.io;

import java.io.*;
import java.util.zip.*;

/**
 * @author lawliet.L
 */
public class ZipIoTest {

    public static void main(String[] args) throws IOException {
        zip("hello.zip",new File("basic"));
//        unzip("hello.zip");
    }

    private static void zip(String filename, File file) throws IOException {
        System.out.println("压缩中...");
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(filename));
        executeZip(zipOutputStream,file,"");
        zipOutputStream.close();
        System.out.println("压缩完成...");
    }

    private static void unzip(String filename) {
        File file = new File(filename);
        ZipInputStream zipInputStream;
        try {
            ZipFile zipFile = new ZipFile(file);
            zipInputStream = new ZipInputStream(new FileInputStream(file));
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                File tmp = new File(zipEntry.getName());
                if (!tmp.exists()) {
                    tmp.getParentFile().mkdirs();
                    FileOutputStream outputStream = new FileOutputStream(tmp);
                    InputStream inputStream = zipFile.getInputStream(zipEntry);
                    int count = 0;
                    while ((count = inputStream.read()) != -1) {
                        outputStream.write(count);
                    }
                    outputStream.close();
                    inputStream.close();
                }
                zipInputStream.closeEntry();
                System.out.println(zipEntry.getName());
            }
            zipInputStream.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void executeZip(ZipOutputStream out, File f, String base) throws IOException {
        if (f.isDirectory()) {
            File[] fileList = f.listFiles();
            if (base.length() != 0) {
                out.putNextEntry(new ZipEntry(base + "/"));
            }
            for (File file : fileList) {
                executeZip(out,file,base + "/" + file);
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
