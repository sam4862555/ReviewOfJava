package com.test.designPattern.mediator;

/**
 * Created by szh on 2017/8/28.
 */
//抽象中介者
abstract class Mediator {
    public abstract void componentChanged(Component c);
}