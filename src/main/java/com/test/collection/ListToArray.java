package com.test.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by szh on 2017/11/9.
 */

class Point{
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){

        StringBuffer sb = new StringBuffer();
        sb.append("x : ").append(this.x).append("\n");
        sb.append("y: ").append(this.y).append("\n");
        return sb.toString();
    }
}


public class ListToArray {

    public static void main(String[] args){
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(1,2));
        pointList.add(new Point(3,4));

        Point[] points = new Point[pointList.size()];
        pointList.toArray(points);

        System.out.println("Points length : " + points.length);
        for(Point x : points){
            System.out.println(x);
        }
    }
}
