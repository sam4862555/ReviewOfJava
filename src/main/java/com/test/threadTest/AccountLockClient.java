package com.test.threadTest;

/**
 * Created by szh on 2017/8/31.
 */

class DrawThreadLock extends Thread {
    private double drawNum = 0;
    private AccountLock account = null;

    public DrawThreadLock(double drawNum, AccountLock account) {
        this.drawNum = drawNum;
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.draw(drawNum);
        }
    }
}

class DepositThreadLock extends Thread {

    private double depositNum = 0;
    private AccountLock account = null;

    public DepositThreadLock(double depositNum, AccountLock account) {
        this.depositNum = depositNum;
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(depositNum);
        }
    }
}

public class AccountLockClient {


    public static void main(String[] args) {
        AccountLock newAccount = new AccountLock(023);
        Thread drawThread1 = new Thread(new DrawThreadLock(90.0, newAccount));
        Thread depositThread1 = new Thread(new DepositThreadLock(30.0, newAccount));
        Thread depositThread2 = new Thread(new DepositThreadLock(30.0, newAccount));
        Thread depositThread3 = new Thread(new DepositThreadLock(30.0, newAccount));
        drawThread1.start();
        depositThread1.start();
        depositThread2.start();
        depositThread3.start();
    }

}
