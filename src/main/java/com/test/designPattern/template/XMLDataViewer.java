package com.test.designPattern.template;

/**
 * Created by szh on 2017/8/29.
 */
class XMLDataViewer extends DataViewer {
    //实现父类方法：获取数据
    public void GetData() {
        System.out.println("从XML文件中获取数据。");
    }

    //实现父类方法：显示数据，默认以柱状图方式显示，可结合桥接模式来改进
    public void DisplayData() {
        System.out.println("以柱状图显示数据。");
    }

    //覆盖父类的钩子方法
    public boolean IsNotXMLData() {
        return false;
    }
}
