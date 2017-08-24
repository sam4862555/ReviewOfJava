package com.test.designPattern.flyweight;

//围棋棋子类：抽象享元类
abstract class IgoChessman {

    public abstract String getColor();

    public void display(Coordinates s) {
        System.out.println("棋子颜色：" + this.getColor() +"\n棋子坐标 X : "+s.getX()+" Y : "+s.getY());
    }
}

//黑色棋子类：具体享元类
class BlackIgoChessman extends IgoChessman {

    public String getColor() {
        return "黑色";
    }
}

//白色棋子类：具体享元类
class WhiteIgoChessman extends IgoChessman {

    public String getColor() {
        return "白色";
    }

}