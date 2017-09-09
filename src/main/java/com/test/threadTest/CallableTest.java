package com.test.threadTest;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by szh on 2017/8/30.
 */
public class CallableTest {


    public static void main(String[] args) throws Exception {
        FutureTask<ReturnStruct> task = new FutureTask<ReturnStruct>(new Callable<ReturnStruct>() {
            @Override
            public ReturnStruct call() throws Exception {
                for (long sum = 0, i = 0; i < 1000000; i++) {
                    for (int j = 0; j < 100000; j++) {
                        sum += i;

                    }
                    if (i == 999999) {
                        System.out.println("at the end");
                    }
                }
                return new ReturnStruct(1, 2);
            }
        });
        Thread returnTest = new Thread(task, "testCallableThread");
        returnTest.start();
        System.out.println(new Date());
        System.out.println("X : " + task.get(2, TimeUnit.MILLISECONDS).getX() + " Y : " + task.get(2, TimeUnit.MILLISECONDS).getY());
        System.out.println(new Date());

        FutureTask<Integer> task2 = new FutureTask<Integer>(()-> 3);
    }


}

class ReturnStruct {

    private int x;

    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    ReturnStruct(int x, int y) {
        this.x = x;
        this.y = y;
    }
}