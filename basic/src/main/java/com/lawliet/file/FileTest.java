package com.lawliet.file;

import java.io.*;

/**
 * @author lawliet.L
 */
public class FileTest {

    public static void main(String[] args) {
        /*File file = new File("test.txt");
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
        }*/

        try {
            cut("F:\\zql\\idea_work\\Java\\basic\\src\\com\\lawliet\\file\\test.txt", 20);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 切割文件
     * @param filePath 文件全路径
     * @param size 切割后的每个文件的大小
     * @throws FileNotFoundException 文件找不到
     */
    private static void cut(String filePath, int size) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        long fileLength = file.length();
        int count = (int) (fileLength % size == 0 ? fileLength / size : (fileLength / size) + 1);

        byte[] bytes = new byte[(int) fileLength];
        fileInputStream.read(bytes);
        fileInputStream.close();

        for (int i = 1; i <= count; i++) {
            String cutFileName = file.getParent() + File.separator + "cut" + i + ".txt";
            FileOutputStream fileOutputStream = new FileOutputStream(cutFileName);
            if (i == count) {
                // 最后一个文件单独处理
                fileOutputStream.write(bytes, size * (i - 1), (int) (fileLength - size * (i - 1)));
            } else {
                fileOutputStream.write(bytes, size * (i - 1), size);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
        }

    }
}
