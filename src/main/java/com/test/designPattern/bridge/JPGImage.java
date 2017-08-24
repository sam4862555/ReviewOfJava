package com.test.designPattern.bridge;

/**
 * Created by szh on 2017/8/22.
 */
//JPG格式图像：扩充抽象类
public class JPGImage extends Image {
    public void parseFile(String fileName) {
        //模拟解析JPG文件并获得一个像素矩阵对象m;
        Matrix m = new Matrix();
        imp.doPaint(m);
        System.out.println(fileName + "，格式为JPG。");
    }
}