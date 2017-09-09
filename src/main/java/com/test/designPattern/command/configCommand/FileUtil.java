package com.test.designPattern.command.configCommand;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by szh on 2017/8/26.
 */
//工具类：文件操作类
class FileUtil {
    //将命令集合写入日志文件
    public static void writeCommands(ArrayList commands) {
        try {
            FileOutputStream file = new FileOutputStream("resource/config/commandPatternConfig.log");
            //创建对象输出流用于将对象写入到文件中
            ObjectOutputStream objout = new ObjectOutputStream(new BufferedOutputStream(file));
            //将对象写入文件
            objout.writeObject(commands);
            objout.close();

            //Java对象序列化
            File outFile = new File("out/test.log");
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(fileOutputStream));
            objectOutputStream.writeObject(commands);
            objectOutputStream.close();


        } catch (Exception e) {
            System.out.println("命令保存失败！");
            e.printStackTrace();
        }
    }

    //从日志文件中提取命令集合
    public static ArrayList readCommands() {
        try {
            FileInputStream file = new FileInputStream("resource/config/commandPatternConfig.log");
            //创建对象输入流用于从文件中读取对象
            ObjectInputStream objin = new ObjectInputStream(new BufferedInputStream(file));
            //将文件中的对象读出并转换为ArrayList类型
            ArrayList commands = (ArrayList) objin.readObject();
            objin.close();

            //对象的反序列化
            File source = new File("out/test.log");
            FileInputStream fileInputStream = new FileInputStream(source);
            ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(fileInputStream));
            ArrayList result = (ArrayList) objectInputStream.readObject();
            objectInputStream.close();

            return commands;
        } catch (Exception e) {
            System.out.println("命令读取失败！");

            File logfile = new File("resource/config/commandPatternConfig.log");
            try {
                logfile.createNewFile();
            }catch (Exception l){
                l.printStackTrace();
            }

            e.printStackTrace();
            return null;
        }
    }
}