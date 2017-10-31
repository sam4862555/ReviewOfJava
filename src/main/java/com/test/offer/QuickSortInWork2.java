package com.test.offer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by szh on 2017/10/20.
 */

class Node{

    Node(int i){
        this.value = i;
    }

    public int value;
}

public class QuickSortInWork2 {




    //从大到小排列, partNum作为分类的依据
    // > partNum 的数据都放在前面
    // <= partNum 的数据都放在后面
    public static void QuickSortWork(List<Node> source, int partNum) {

        partNum++;      //历史原因

        if (source.size() == 0)
            return;

        //search Start , search End 既表示了是否有查找到，也表示了需要替换的元素位置
        int searchStart = -1;
        int searchEnd = -1;
        int i = 0, j = source.size() - 1;

        while (i <= j) {

            while (i <= j) {
                if (source.get(i).value < partNum) {
                    searchStart = i;
                    ++i;
                    break;
                } else {
                    ++i;
                }
            }

            while (i <= j) {
                if (source.get(j).value >= partNum) {
                    searchEnd = j;
                    --j;
                    break;
                } else {
                    --j;
                }
            }


            if ((searchEnd != -1) && (searchStart != -1)) {
                Node startNode = source.get(searchStart);
                Node endNode = source.get(searchEnd);

                source.set(searchStart,endNode);
                source.set(searchEnd,startNode);

                searchStart = -1;
                searchEnd = -1;
            }
        }
    }

    public static void main(String[] args) {

//        int[] source = { 1, 2, 3};
//        int[] source = { 1, 1, 2, 3};
//        int[] source = { 1, 1, 3, 4, 3, 3, 6, 8, 9, 9, 9};


        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(1));
        nodes.add(new Node(1));
        nodes.add(new Node(2));
        nodes.add(new Node(3));
        nodes.add(new Node(4));
        nodes.add(new Node(2));
        nodes.add(new Node(2));
        nodes.add(new Node(3));
        nodes.add(new Node(8));
        nodes.add(new Node(7));

        QuickSortWork(nodes, 3);
        for(int i = 0; i< nodes.size(); i++){
            System.out.print(nodes.get(i).value + " ");
        }
        System.out.println();
    }

}
