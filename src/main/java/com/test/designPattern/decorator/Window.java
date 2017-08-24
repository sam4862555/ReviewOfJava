package com.test.designPattern.decorator;

/**
 * Created by szh on 2017/8/24.
 */
//窗体类：具体构件类
class Window extends Component
{
    public void display()
    {
        System.out.println("显示窗体！");
    }
}