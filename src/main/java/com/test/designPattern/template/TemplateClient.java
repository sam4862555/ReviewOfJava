package com.test.designPattern.template;

/**
 * Created by szh on 2017/8/29.
 */
public class TemplateClient {
    public static void main(String[] args)
    {
        DataViewer dv;
        dv = new XMLDataViewer();
        dv.Process();
    }
}
