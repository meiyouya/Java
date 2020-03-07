package com.zql.channel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {

    public static void main(String[] args) throws Exception{
        RandomAccessFile randomAccessFile = new RandomAccessFile("C:\\Users\\没有牙\\Desktop\\nio\\nio-data.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);    // 创建容量为5的Buffer
        int bytesRead = fileChannel.read(byteBuffer);   // 将数据读出，写入Buffer
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            byteBuffer.flip();      // 是Buffer处于可被读取状态
            while (byteBuffer.hasRemaining()) {
                System.out.println((char)byteBuffer.get());     // 一次读取一个字节
            }
            byteBuffer.clear();     // 清空缓存区，使Buffer处于可被写状态，以方便继续将读取的数据写入Buffer
            bytesRead = fileChannel.read(byteBuffer);
        }
        randomAccessFile.close();
    }
}
