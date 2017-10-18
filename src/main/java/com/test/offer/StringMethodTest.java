package com.test.offer;

/**
 * Created by szh on 2017/9/10.
 */
public class StringMethodTest {
    class Point{
        int x;
        int y;
        Point(int x ,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void ChangeString(String what){
        what += "是否发生变化了呢？";
    }

    public void changeString(String what){
        what += "发生变化了吧！！！！";
    }

    public void ChangePoint(Point x){
        x.x += 2;
        x.y += 2;
    }


    public static void main(String[] args){

        String ss = new String("before change");
        ChangeString(ss);
        System.out.println(ss);
        StringMethodTest test = new StringMethodTest();
        test.changeString(ss);
        System.out.println(ss);


        StringMethodTest.Point point = new StringMethodTest().new Point(2,2);
        test.ChangePoint(point);
        System.out.println("x :" + point.x +"\ny : " +point.y);

    }
}
