package com.zql.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author lawliet.L
 */
public class ZipIOTest {

    private void zip(String zipFileName, File inputFile) throws Exception {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFileName));
        if (inputFile.isDirectory()) {
            File[] files = inputFile.listFiles();

        }
    }
}
