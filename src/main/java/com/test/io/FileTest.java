package com.test.io;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by szh on 2017/8/23.
 */
public class FileTest {

    public static void main(String[] args){
        File s = new File("resource/xml/productList.xml");
        if(s.exists()){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }


        FileInputStream stream = null;
        byte[]  buff = new byte[1024];
        try{
            stream = new FileInputStream(s);
            while(stream.read(buff)>0){
                System.out.println(new String(buff));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
