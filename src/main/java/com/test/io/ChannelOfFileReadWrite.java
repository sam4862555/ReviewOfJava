package com.test.io;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by szh on 2017/9/9.
 */
public class ChannelOfFileReadWrite {

    public static void main(String[] args) throws Exception {
        RandomAccessFile randomFile = new RandomAccessFile("resource/file/randomAccessFile.txt", "rw");
        FileChannel fileChannel = randomFile.getChannel();

        //每次最多读取40个字节
        ByteBuffer buffer = ByteBuffer.allocate(40);
        int i = 0;
        while (fileChannel.read(buffer) > 0) {
            buffer.flip();
            Charset charset = Charset.forName("UTF-8");
            CharBuffer cacheBuffer = charset.decode(buffer);
            System.out.println("第" + (++i) + "次读取，读取的内容是\n" + new String(cacheBuffer.array()));
            buffer.clear();
        }

        fileChannel.position(randomFile.length());
        System.out.println("当前指针的位置是 : " + fileChannel.position() + "\n" + "文件的大小是 : " + randomFile.length());
        ByteBuffer outBuffer = ByteBuffer.allocate(400);
        outBuffer.put("\n 向最后追加一行文字".getBytes());
        outBuffer.flip();
        fileChannel.write(outBuffer);


        // MappedByteBuffer 真正的返回值类型，貌似有自动扩容的功能
        ByteBuffer fileBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, randomFile.length());
        System.out.println("capacity : " + fileBuffer.capacity() + "\n" + "position : " + fileBuffer.position() + "\n" + "limit : " + fileBuffer.limit());
    }

}
