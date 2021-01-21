package com.lawliet.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Scanner;

/**
 * @author dell
 */
public class NioTest {

    public static void main(String[] args) throws IOException {
        File file = new File("F:\\zql\\idea_work\\Java\\basic\\src\\com\\lawliet\\nio\\nio.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        // nio通过channel来连接文件
        FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
        // 分配大小为100的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);

        System.out.println("请输入要保存的字符");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        // 将用户输入的字符写入到缓冲区
        byteBuffer.put(line.getBytes());
        System.out.println("写入数据后的指针变化-position：" + byteBuffer.position() + " limit："
                + byteBuffer.limit() + " capacity：" + byteBuffer.capacity());

        // 为输出数据做准备
        byteBuffer.flip();
        System.out.println("准备输出后的指针变化-position：" + byteBuffer.position() + " limit："
                + byteBuffer.limit() + " capacity：" + byteBuffer.capacity());

        // 将缓冲区的数据写入到channel
        channel.write(byteBuffer);
        byteBuffer.clear();
        System.out.println("写入到channel后的指针变化-position：" + byteBuffer.position() + " limit："
                + byteBuffer.limit() + " capacity：" + byteBuffer.capacity());
        channel.close();

        FileChannel readChannel = new RandomAccessFile(file, "r").getChannel();
        while (readChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            Charset charset = Charset.forName("UTF-8");
            CharsetDecoder decoder = charset.newDecoder();
            System.out.println(decoder.decode(byteBuffer));
            byteBuffer.clear();
        }
        readChannel.close();


    }
}
