package com.test.offer;

/**
 * Created by szh on 2017/8/24.
 */
class StringDemo {
    public static void main(String args[]) {
        String str1 = "abcd";
        String str2 = "abcd";
        String str3 = "ab" + "cd";
        String str4 = "ab";
        str4 += "cd";
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);
        str2 += "e";
        System.out.println(str1 == str2);
    }
}