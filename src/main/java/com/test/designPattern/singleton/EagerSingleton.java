package com.test.designPattern.singleton;

/**
 * Created by szh on 2017/8/11.
 */
//饿汉式单例模式
//优点 ： 不存在线程安全问题
//缺点 ： 需要在类加载的时候完成类的初始化，比较耗费资源
public class EagerSingleton {

    private EagerSingleton() {
        //TODO: 完成一些初始化
    }

    private static final EagerSingleton singleton = new EagerSingleton();

    public static EagerSingleton getInstance() {
        return singleton;
    }


    public static void main(String[] args) {
        EagerSingleton s1 = EagerSingleton.getInstance();
        EagerSingleton s2 = EagerSingleton.getInstance();
        if (s1 == s2) {
            System.out.println("s1 s2 为同一个对象");
        }else{
            System.out.println("s1 s2 不是同一个对象");
        }
    }

}
