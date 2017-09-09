package com.test.designPattern.observer;

/**
 * Created by szh on 2017/8/28.
 */
//抽象观察类
interface Observer {
    public String getName();
    public void setName(String name);
    public void help(); //声明支援盟友方法
    public void beAttacked(AllyControlCenter acc); //声明遭受攻击方法
}
