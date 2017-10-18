package com.test.io;


import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by szh on 2017/9/9.
 */
public class ByteBufferTest {

    public static void main(String[] args) throws Exception {
        FileChannel test = new FileInputStream("resource/file/buffer.txt").getChannel();
        //1.分配空间
        ByteBuffer buffer = ByteBuffer.allocate(200);
        System.out.println("initial status \ncapacity : " + buffer.capacity() + "\n" + "limit : " + buffer.limit() + "\n" + "position : " + buffer.position());
        //2.存储数据
        buffer.put("今天晚上吃了顿大餐 ".getBytes());
        test.read(buffer);
        System.out.println("after put a string status \ncapacity : " + buffer.capacity() + "\n" + "limit : " + buffer.limit() + "\n" + "position : " + buffer.position()+ "\n");
        //3.为读取数据做准备
        buffer.flip();
        System.out.println("after flip status \ncapacity : " + buffer.capacity() + "\n" + "limit : " + buffer.limit() + "\n" + "position : " + buffer.position()+ "\n");
        //4.读取数据
        byte[] outStore = new byte[200];
        buffer.get(outStore, 0, buffer.limit());
        Charset decoder = Charset.forName("UTF-8");
        //ByteBuffer cacheBuffer = CharBuffer.allocate(200).p
        System.out.println("final String : " + new String(outStore));
        System.out.println("flip && decode \ncapacity : " + buffer.capacity() + "\n" + "limit : " + buffer.limit() + "\n" + "position : " + buffer.position()+ "\n");
        buffer.flip();
        System.out.println("final String : " + decoder.decode(buffer));

        //5.为下一次做准备
        buffer.clear();

    }
}
