package com.test.threadTest;

/**
 * Created by szh on 2017/8/31.
 */
public class Account {

    private long accountNo;

    private double balance;

    int countDrawNum = 0;

    int countDepositNum = 0;


    public Account(long accountNo) {
        this.accountNo = accountNo;
        this.balance = 0.0;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void draw(double drawAmount) {
        try {
            synchronized (this) {
                while (true) {
                    if (balance - drawAmount < 0) {
                        this.wait();
                    } else {
                        balance -= drawAmount;
                        countDrawNum++;
                        System.out.println("第" + countDrawNum + "次取钱,取钱金额" + drawAmount + "  余额" + balance);
                        this.notifyAll();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deposit(double depositAmount) {
        try {
            synchronized (this) {
                balance += depositAmount;
                countDepositNum++;
                System.out.println("第" + countDepositNum + "次存钱,存钱金额" + depositAmount + "  余额" + balance);
                this.notifyAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
