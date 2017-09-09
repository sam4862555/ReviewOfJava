package com.test.threadTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by szh on 2017/8/31.
 */
public class AccountLock {

    private long accountNo;

    private double balance;

    int countDrawNum = 0;

    int countDepositNum = 0;

    //控制线程的锁Lock 与 协调类Condition

    Lock lock = new ReentrantLock(); // 可重入锁 ReentrantLock();

    Condition condition = lock.newCondition();

    public AccountLock(long accountNo) {
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
        lock.lock();
        try {
            if (balance - drawAmount < 0) {
                condition.await();
                balance -= drawAmount;
                countDrawNum++;
                System.out.println("第" + countDrawNum + "次取钱,取钱金额" + drawAmount + "  余额" + balance);
                condition.signalAll();
            } else {
                balance -= drawAmount;
                countDrawNum++;
                System.out.println("第" + countDrawNum + "次取钱,取钱金额" + drawAmount + "  余额" + balance);
                condition.signalAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void deposit(double depositAmount) {
        lock.lock();
        try {
            balance += depositAmount;
            countDepositNum++;
            System.out.println("第" + countDepositNum + "次存钱,存钱金额" + depositAmount + "  余额" + balance);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
