package com.test.designPattern.factory;

/**
 * Created by szh on 2017/8/10.
 */
public abstract class ProductPrototype {

    public abstract void DoSomething();

    public void AlreadyKnow(){
        System.out.println("Something already know");
    }
}
