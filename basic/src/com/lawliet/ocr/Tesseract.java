package com.lawliet.ocr;

import java.io.*;
import java.util.ArrayList;

/**
 * @author lawliet.L
 */
public class Tesseract {

    /**
     * 行结束符
     */
    private static final String EOL = System.getProperty("line.separator");

    public static String distinguishDigit(File image) throws IOException, InterruptedException {
        File result = new File(image.getParent() + "\\result");
        ProcessBuilder pb = new ProcessBuilder();
        ArrayList<String> cmd = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String os = System.getProperty("os.name");
        cmd.add("tesseract");
        cmd.add(image.getAbsolutePath());
        cmd.add(result.getName());
        pb.directory(image.getParentFile());
        pb.command(cmd);
        Process process = pb.start();
        int code = process.waitFor();
        if (code == 0) {
            // 正常退出
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(
                    result.getAbsolutePath() + ".txt"), "UTF-8"));
            String str;
            while ((str = reader.readLine()) != null) {
                sb.append(str).append(EOL);
            }
            reader.close();
        } else {
            // 异常退出
            String msg;
            switch (code)
            {
                case 1:
                    msg = "Errors accessing files. There may be spaces in your image's filename.";
                    break;
                case 29:
                    msg = "Cannot recognize the image or its selected region.";
                    break;
                case 31:
                    msg = "Unsupported image format.";
                    break;
                default:
                    msg = "Errors occurred.";
            }
            throw new RuntimeException(msg);
        }
        return sb.toString().replaceAll("\\s*", "");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("C:\\Users\\没有牙\\Desktop\\digit.jpg");
        String res = distinguishDigit(file);
        System.out.println(res);
    }
}
