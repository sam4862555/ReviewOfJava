package com.test.designPattern.flyweight;

/**
 * Created by szh on 2017/8/24.
 */
class FlyweightClient {
    public static void main(String args[]) {
        IgoChessman black1, black2, black3, white1, white2;
        IgoChessmanFactory factory;
        //获取享元工厂对象
        factory = IgoChessmanFactory.getInstance();
        //通过享元工厂获取三颗黑子
        black1 = factory.getIgoChessman("b");
        black2 = factory.getIgoChessman("b");
        black3 = factory.getIgoChessman("b");
        System.out.println("判断两颗黑子是否相同：" + (black1 == black2));
        //通过享元工厂获取两颗白子
        white1 = factory.getIgoChessman("w");
        white2 = factory.getIgoChessman("w");
        System.out.println("判断两颗白子是否相同：" + (white1 == white2));
        //显示棋子
        black1.display(new Coordinates(1,2));

        black2.display(new Coordinates(1,3));
        black3.display(new Coordinates(2,2));
        white1.display(new Coordinates(4,2));
        white2.display(new Coordinates(1,8));
    }
}