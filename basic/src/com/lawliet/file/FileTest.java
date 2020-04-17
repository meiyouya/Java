package com.zql.file;

import java.io.File;
import java.io.IOException;

/**
 * @author lawliet.L
 */
public class FileTest {

    public static void main(String[] args) {
        File file = new File("test.txt");
        if (file.exists()) {
            System.out.println("文件已存在");
            System.out.println("文件名称：" + file.getName());
            System.out.println("文件绝对路径：" + file.getAbsolutePath());
        } else {
            System.out.println("文件不存在，正在创建");
            try {
                if (file.createNewFile()) {
                    System.out.println("创建成功");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
