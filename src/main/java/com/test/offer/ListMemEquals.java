package com.test.offer;

import java.util.*;

/**
 * Created by szh on 2017/8/24.
 */

class Stu{

    Object s = new Object();

    private int num;

    public Stu(int num){
        this.setNum(num);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object stu){
        if(stu.getClass() != this.getClass())
            return false;
        return ((Stu)stu).getNum() == this.getNum() ? true : false;
    }

    @Override
    public int hashCode(){
        return this.num;
    }
}

public class ListMemEquals {

    public static Set hashSet = new HashSet<Stu>();
    public static Map hashMap = new HashMap<Stu,Integer>();
    public static Set linkedHashSet = new LinkedHashSet<>();

    public static void main(String[] args) {
        hashSet.add(new Stu(2));
        hashSet.add(new Stu(2));
        System.out.println(hashSet.size());
        System.out.println(hashSet.contains(new Stu(2)));

        hashMap.put(new Stu(2),2);
        hashMap.put(new Stu(2),1);
        System.out.println(hashMap.size());

        linkedHashSet.add(new Stu(2));
        linkedHashSet.add(new Stu(2));
        System.out.println(linkedHashSet.size());


    }
}
