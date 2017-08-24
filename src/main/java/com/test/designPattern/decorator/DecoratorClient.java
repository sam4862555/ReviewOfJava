package com.test.designPattern.decorator;

/**
 * Created by szh on 2017/8/24.
 */
public class DecoratorClient
{
    public static void main(String args[])
    {
        Component component,componentSB; //使用抽象构件定义
        component = new Window(); //定义具体构件
        componentSB = new ScrollBarDecorator(component); //定义装饰后的构componentSB.display();
        componentSB.display();
    }
}