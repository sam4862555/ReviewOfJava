package com.test.designPattern.factory;

/**
 * Created by szh on 2017/8/10.
 */
public class ProductA extends ProductPrototype {
    @Override
    public void DoSomething() {
        System.out.println("Product A Do Something");
    }

    @Override
    public void AlreadyKnow() {
        super.AlreadyKnow();
        System.out.println("Product A OverWrite AlreadyKnow");
    }
}
