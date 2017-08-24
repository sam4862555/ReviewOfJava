package com.test.designPattern.flyweight;

/**
 * Created by szh on 2017/8/24.
 */
//坐标类：外部状态类
class Coordinates {
    private int x;
    private int y;
    public Coordinates(int x,int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return this.y;
    }
    public void setY(int y) {
        this.y = y;
    }
}