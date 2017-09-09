package com.test.io;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by szh on 2017/9/9.
 */
public class ChannelOfFileRead {

    public static void main(String[] args) throws Exception {
        FileInputStream stream = new FileInputStream("resource/file/randomAccessFile.txt");
        FileChannel fileChannel = stream.getChannel();

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
    }

}
