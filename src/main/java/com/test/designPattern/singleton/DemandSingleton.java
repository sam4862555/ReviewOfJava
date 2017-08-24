package com.test.designPattern.singleton;

import com.test.classTest.InheritTest;

/**
 * Created by szh on 2017/8/11.
 */
public class DemandSingleton {

    private DemandSingleton(){
    }

    public static DemandSingleton getInstance(){
        return InnerClass.singleton;
    }

    static private class InnerClass{
        private static final DemandSingleton singleton  = new DemandSingleton();
    }

    public static void main(String[] args){
        DemandSingleton s1 = DemandSingleton.getInstance();
        DemandSingleton s2 = DemandSingleton.getInstance();
        if(s1 == s2){
            System.out.println("Demand Hold 方式实现的单例模式：s1 s2 为同一个实例");
        }
    }
}
