package com.zql.hutool.io;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * @author lawliet.L
 */
public class FileUtilTest {

    public static void main(String[] args) {
        File[] ls = FileUtil.ls("/projects");
        for (File file : ls) {
            System.out.println(file.getAbsolutePath());
        }
        File testFile = FileUtil.touch("test.txt");
        testFile.delete();
    }
}
