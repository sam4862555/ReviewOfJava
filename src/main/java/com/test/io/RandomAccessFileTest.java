package com.test.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by szh on 2017/9/9.
 */
public class RandomAccessFileTest {

    public static void main(String[] args) {
        File testFile = new File("resource/file/randomAccessFile.txt");
        try {
            if (!testFile.exists()) {
                testFile.createNewFile();
            } else {
                //testFile.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        RandomAccessFile inStream, outStream = null;
        FileChannel inChannel, outChannel = null;
        try {
            inStream = new RandomAccessFile("D:\\Users\\szh\\IdeaProjects\\ReviewOfJava\\src\\main\\java\\com\\test\\io\\RandomAccessFileTest.java", "r");
            inChannel = inStream.getChannel();
            ByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inStream.length());

            outStream = new RandomAccessFile(testFile, "rws");
            outStream.seek(testFile.length());
            System.out.println("当前文件指针的位置是" + outStream.getFilePointer());
            outStream.write("向其中追加一段内容\r\n".getBytes());
            outChannel = outStream.getChannel();
            outChannel.write(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }


    }
}
