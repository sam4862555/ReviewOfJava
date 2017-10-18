package com.test.io;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import java.util.Set;

/**
 * Created by szh on 2017/10/12.
 */
public class PropertiesRead {

    public static void main(String[] args) {
        try {
            Properties properties = new Properties();

            ClassLoader classLoader = PropertiesRead.class.getClassLoader();
            /**
             getResource()方法会去classpath下找这个文件，获取到url resource, 得到这个资源后，调用url.getFile获取到 文件 的绝对路径
             */
            URL url = classLoader.getResource("envConfig.properties");
            File file = new File(url.getFile());
            if(file.exists()){
                System.out.println("文件存在 ： " + "可算找到你了");
            }

            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);


            Set<Object> List = properties.keySet();

            for (Object tmp : List) {
                System.out.println("KEY : " + (String) tmp );
            }

            String path = properties.getProperty("dmp.upload.seedFileLocation");
            System.out.println(path);

            CreateDirectory createDirectory = new CreateDirectory();
            createDirectory.createParentDirWIN(path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
