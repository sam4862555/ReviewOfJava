package com.test.io;

import java.io.File;

/**
 * Created by szh on 2017/10/12.
 */
public class CreateDirectory {

    private static String WIN_SEPARATOR = new String("\\");
    private static String LINUX_SEPARATOR = new String("/");

    public static boolean isExistPath(String path) throws InterruptedException {
        String[] paths = path.split("\\\\");
        StringBuffer fullPath = new StringBuffer();
        for (int i = 0; i < paths.length; i++) {
            fullPath.append(paths[i]).append("\\\\");
            File file = new File(fullPath.toString());
            if (paths.length - 1 != i) {
                if (!file.exists()) {
                    file.mkdir();
                    System.out.println("创建目录为：" + fullPath.toString());
                    Thread.sleep(1500);
                }
            }
        }
        File file = new File(fullPath.toString());
        if (!file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public void createParentDir(String path) throws Exception {
        String systemSeparator = File.separator;
        if (systemSeparator.equals(WIN_SEPARATOR)) {
            createParentDirWIN(path);
        } else if (systemSeparator.equals(LINUX_SEPARATOR)) {
            createParentDirLinux(path);
        }
    }

    //Windows
    public void createParentDirWIN(String path) throws Exception {

        //Split中特殊字符分割： http://blog.csdn.net/myfmyfmyfmyf/article/details/37592711
        // \ 用 “\\\\”
        String[] pathArr = path.split("\\\\");
        System.out.println("length : " + pathArr.length);

        StringBuffer tmpPath = new StringBuffer();
        for (int i = 0; i < pathArr.length; i++) {
            tmpPath.append(pathArr[i]).append(WIN_SEPARATOR);

            if (0 == i) continue;

            File file = new File(tmpPath.toString());

            if (!file.exists()) {
                file.mkdir();
                System.out.println("当前创建的目录是 : " + tmpPath.toString());
            }

        }
    }

    //Linux
    public void createParentDirLinux(String path) throws Exception {

        String[] pathArr = path.split(LINUX_SEPARATOR);

        StringBuffer tmpPath = new StringBuffer();
        for (int i = 0; i < pathArr.length; i++) {
            tmpPath.append(pathArr[i]).append(LINUX_SEPARATOR);

            File file = new File(tmpPath.toString());
            if (!file.exists()) {
                file.mkdir();
                System.out.println("当前创建的目录是 : " + tmpPath.toString());
            }
        }
    }


    public static void main(String[] args) throws Exception {
//        String path = "E:\\DevFileServer\\dmp\\firstPartyAudience";
//        try {
//            isExistPath(path);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        String separator = File.separator;
        System.out.println("current File separator : " + separator);

        String testPath = "E:\\\\testCreate" + File.separator + "dmp" + "\\\\" + "FirstPartyAudience";
        File testFile = new File(testPath);
        System.out.println(testPath);
        if (testFile.exists()) {
            System.out.println("磁盘存在");
        } else {
            testFile.mkdir();
        }

        CreateDirectory createDirectory = new CreateDirectory();
        createDirectory.createParentDir("E:\\testCreate\\dmp\\FirstPartyAudience\\2017\\ss\\");

    }
}
