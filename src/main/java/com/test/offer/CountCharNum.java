package com.test.offer;

/**
 * Created by szh on 2017/8/24.
 */
public class CountCharNum {

    public static void main(String[] args){
        String a = "sssssssssdsdsdsadsadsadasdasdasd ..sdsds.dsds";

        int[] countArr = new int[512];
        char[] charArr = a.toCharArray();

        for(int i=0; i<charArr.length; i++){
            countArr[charArr[i]]++;
        }

        int max = 0;
        int charIndex = 0;

        for(int i = 'a'; i <= 'z'; i++){
             charIndex = countArr[i] > max ? i : charIndex;
             max = countArr[i] > max ? max : countArr[i];
        }
        for(int i = 'A'; i <= 'Z'; i++){
            charIndex = countArr[i] > max ? i : charIndex;
            max = countArr[i] > max ? max : countArr[i];
        }

        System.out.println("出现最多的字符是 : "+(char)charIndex + "\n出现的次数 : "+max);

    }

}
