package com.test.designPattern.strategy;

/**
 * Created by szh on 2017/8/29.
 */
//学生票折扣类：具体策略类
class StudentDiscount implements Discount {
    public double calculate(double price) {
        System.out.println("学生票：");
        return price * 0.8;
    }
}
