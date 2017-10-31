package com.test.basic;

/**
 * Created by szh on 2017/10/23.
 */
public class StringReplace {

    public static void main(String[] args){

        String m = "122,322,323,4313,3323,232323,3232323,2313,13,13,131,3123,123,13,123213,";
        StringBuffer buffer = new StringBuffer(m);
        StringBuffer newBuffer =  buffer.replace(m.length()-1, m.length(), "");
        String newString = newBuffer.toString();

//        String newString = m.replace(m.length()-1,m.length(),"");
        System.out.println(newString);
    }

}
