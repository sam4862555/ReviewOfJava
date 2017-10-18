package com.test.basic;

/**
 * Created by szh on 2017/10/18.
 */
public class IntegerTest {

    public static void main(String[] args){
        Integer a = 3002;
        Integer b = 3002;
        System.out.println(a==b);

        StringBuffer sb = new StringBuffer();

        sb.append("[{");
        sb.append(" \"name\" : ").append(" \""+"test"+"\"").append(",");


        sb.append("}]");

        System.out.println(sb.toString());
    }
}
