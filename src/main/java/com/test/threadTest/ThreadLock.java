package com.test.threadTest;

/**
 * Created by szh on 2017/8/31.
 */

class A {

    public synchronized void Afirst(B b){
        System.out.println("调用A的first");
        try{
            Thread.sleep(200);
        }catch (Exception e){
            e.printStackTrace();
        }
        b.Blast();
    }

    public synchronized void Alast() {
        System.out.println("调用A的last");
    }
}


class B{

    public synchronized void Bfirst(A a){
        System.out.println("调用B的first");
        try{
            Thread.sleep(200);
        }catch (Exception e){
            e.printStackTrace();
        }
        a.Alast();
    }

    public synchronized void Blast(){
        System.out.println("调用B的last");
    }

}


public class ThreadLock implements Runnable{
    A a = new A();
    B b = new B();

    @Override
    public void run (){
        a.Afirst(b);
    }

    public void mainThreadRun(){
        b.Bfirst(a);
    }

    public static void main(String[] args){
        ThreadLock lock = new ThreadLock();
        Thread sub = new Thread(lock);
        sub.start();
        lock.mainThreadRun();
        System.out.println("进入死锁看不到输出");
    }
}
