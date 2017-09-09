package com.test.threadTest;

/**
 * Created by szh on 2017/8/31.
 */
class DrawThread extends Thread {
    private double drawNum = 0;
    private Account account = null;

    public DrawThread(double drawNum, Account account){
        this.drawNum = drawNum;
        this.account = account;
    }

    @Override
    public void run() {
        for(int i=0; i<5; i++){
            account.draw(drawNum);
        }
    }
}

class DepositThread extends Thread {

    private double depositNum = 0;
    private Account account = null;

    public DepositThread(double depositNum, Account account){
        this.depositNum = depositNum;
        this.account = account;
    }

    @Override
    public void run() {
        for(int i=0; i<5; i++){
            account.deposit(depositNum);
        }
    }
}

public class ProducerConsumerClient {
    public static void main(String[] args) {
        Account newAccount = new Account(023);
        Thread drawThread1 = new Thread(new DrawThread(90.0,newAccount));
        Thread depositThread1 = new Thread(new DepositThread(30.0,newAccount));
        Thread depositThread2 = new Thread(new DepositThread(30.0,newAccount));
        Thread depositThread3 = new Thread(new DepositThread(30.0,newAccount));
        drawThread1.start();
        depositThread1.start();
        depositThread2.start();
        depositThread3.start();
    }
}
