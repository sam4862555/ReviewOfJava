package com.test.designPattern.singleton;

/**
 * Created by szh on 2017/8/11.
 */
public class LazySingletonDoubleLock {

    //volatile
    private static volatile LazySingletonDoubleLock singleton = null;

    private LazySingletonDoubleLock() {
        //TODO: To do initialize

    }

    public static LazySingletonDoubleLock getInstance() {
        if (singleton == null) {
            synchronized (LazySingletonDoubleLock.class) {
                if (singleton == null) {
                    singleton = new LazySingletonDoubleLock();
                }
            }
        }
        return singleton;
    }

}
