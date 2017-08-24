package com.test.designPattern.prototype;

/**
 * Created by szh on 2017/8/13.
 */
public class Prototype {

    @Override
    public Prototype clone() {
        System.out.println("Test function of clone.");
        return new Prototype();
    }


    public static void main(String[] args) {
        Prototype s1 = new Prototype();
        Prototype s2 = s1.clone();

//        1. 对任何对象，都有 x.clone()!=x 即克隆对象与原型对象不是同一个对象。
//        2. 对任何对象x , 都有 x.clone().getClass() == x.getClass()
//        克隆独享与原型对象的类型一致
//        3.如果对象x的equals() 方法定义恰当
//        x.clone().equals(x)应成立
        if(s1!=s2){
            System.out.println("x.clone() !=  x 成立");
        }

        if(s1.getClass() == s2.getClass()){
            System.out.println("s1 与 s2的类型一致");
        }

        if(s1.equals(s2)){
            System.out.println("s1 equals s2");
        }

        //没有通过Clone方式创建一个新的对象，但是也没抛出异常，分析愿意，Object 其中有这样一个方法：
        //protected native Object clone() throws CloneNotSupportedException;
        Object s = new Object();
    }

}
