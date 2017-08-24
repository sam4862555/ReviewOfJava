package com.test.designPattern.proxy;

/**
 * Created by szh on 2017/8/24.
 */
public class ProxyClient {
    public static void main(String[] args){
        Subject s = new Proxy();
        s.Request();
    }

}


abstract class Subject {
    public abstract void Request();
}


class RealSubject extends Subject {
    @Override
    public void Request() {
        //业务方法具体实现代码
        System.out.println("RealSubject 类的发送方法");
    }
}


class Proxy extends Subject {
    private RealSubject realSubject = new RealSubject(); //维持一个对真实主题对象public void PreRequest()

    @Override
    public void Request() {
        PreRequest();
        realSubject.Request(); //调用真实主题对象的方法
        PostRequest();
    }

    public void PostRequest() {
        //业务方法具体实现代码
        System.out.println("请求发送");
    }

    public void PreRequest() {
        //业务方法具体实现代码
        System.out.println("请求预处理");
    }
}