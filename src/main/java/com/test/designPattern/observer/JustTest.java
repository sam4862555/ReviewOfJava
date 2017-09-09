package com.test.designPattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by szh on 2017/8/28.
 */
public class JustTest {

    public static void main(String[] args) {
        Observer observer = new Observer() {
            @Override
            public void update(Observable o, Object arg) {

            }
        };

        Observable variable = new Observable();
    }

}
