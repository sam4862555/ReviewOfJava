package com.test.offer;

/**
 * Created by szh on 2017/10/20.
 */
public class QuickSortInWork {

    //从大到小排列, partNum作为分类的依据
    // > partNum 的数据都放在前面
    // <= partNum 的数据都放在后面
    public static int[] QuickSortWork(int[] source, int partNum) {

        partNum++;      //历史原因

        if (source == null || source.length == 0 || source.length == 1)
            return source;

        //search Start , search End 既表示了是否有查找到，也表示了需要替换的元素位置
        int searchStart = -1;
        int searchEnd = -1;
        int i = 0, j = source.length - 1;

        while (i <= j) {

            while (i <= j) {
                if (source[i] < partNum) {
                    searchStart = i;
                    ++i;
                    break;
                } else {
                    ++i;
                }
            }

            while (i <= j) {
                if (source[j] >= partNum) {
                    searchEnd = j;
                    --j;
                    break;
                } else {
                    --j;
                }
            }


            if ((searchEnd != -1) && (searchStart != -1)) {
                int tmp = source[searchStart];
                source[searchStart] = source[searchEnd];
                source[searchEnd] = tmp;

                System.out.println("交换 前 ："+ searchStart + "后 ：" + searchEnd);

                searchStart = -1;
                searchEnd = -1;
            }
        }

        return source;
    }

    public static void main(String[] args) {

//        int[] source = { 1, 2, 3};
//        int[] source = { 1, 1, 2, 3};
//        int[] source = { 1, 1, 3, 4, 3, 3, 6, 8, 9, 9, 9};
        int[] source = { 1, 1, 2, 3, 4, 2, 2, 2, 2, 1, 8, 7};
        source = QuickSortWork(source, 2);
        for(int i = 0; i< source.length; i++){
            System.out.print(source[i] + " ");
        }
        System.out.println();
    }

}
