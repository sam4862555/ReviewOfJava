package com.test.designPattern.bridge;

/**
 * Created by szh on 2017/8/22.
 */
class Client {

    public static void main(String args[]) {
        Image image;
        ImageImp imp;
        image = (Image)BridgePatternXMLUtil.getBean("image");
        imp = (ImageImp)BridgePatternXMLUtil.getBean("os");
        image.setImageImp(imp);
        image.parseFile("小龙女");
    }
}
