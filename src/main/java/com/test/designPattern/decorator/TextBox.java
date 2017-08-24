package com.test.designPattern.decorator;

/**
 * Created by szh on 2017/8/24.
 */
//文本框类：具体构件类
class TextBox extends Component
{
    public void display()
    {
        System.out.println("显示文本框！");
    }
}