package com._180.dmp.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by szh on 2017/10/13.
 */
public class ResourceFileUtil {

    //参数 location: 文件在resource下的 的相对路径地址
    //返回 ：
    // null 文件不存在
    // file 文件存在
    public static synchronized File getResourceFile(String location) {

        File file = null;
        URL url = ResourceFileUtil.class.getClassLoader().getResource(location);

        File resourceFile = new File(url.getFile());
        if (resourceFile.exists()) {
            file = resourceFile;
        }

        return file;
    }

    public static void main(String[] args){
        try {
            File file = ResourceFileUtil.getResourceFile("properties/test");
            if( null != file ){
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream,"UTF-8"));
                String tmpLine = null;
                while((tmpLine = reader.readLine())!= null){
                    System.out.println(tmpLine);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
