package com.test.designPattern.state;

/**
 * Created by szh on 2017/8/29.
 */
//抽象状态类
abstract class AccountState {
    protected Account acc;
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void computeInterest();
    public abstract void stateCheck();
}