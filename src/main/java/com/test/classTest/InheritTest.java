package com.test.classTest;

/**
 * Created by szh on 2017/8/10.
 */
public class InheritTest {
    protected void Show() {
        System.out.println("Father show ");
    }

    public static void main(String[] args) {
        System.out.println("你好！！");
    }
}

class SonClass extends InheritTest {
    @Override
    protected void Show() {
        System.out.println("Son show ");
    }

    public void AnotherShow() {
        System.out.println("Only son have");
    }

    public static void main(String[] args) {

        InheritTest test = new SonClass();
        test.Show();

        if (test instanceof SonClass) {
            SonClass xx = (SonClass) test;
            xx.AnotherShow();
        } else {
            System.out.println("转换成功");
        }


        ///----------------------


        InheritTest test2 = new InheritTest();
        test.Show();

        if (test2 instanceof SonClass) {
            SonClass xx2 = (SonClass) test2;
            xx2.AnotherShow();
        } else {
            System.out.println("转换失败");
        }
    }

}
