package com.test.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by szh on 2017/11/9.
 */
public class ListRemove {

    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("1".equals(item)) {
                list.remove(item);
            }
        }

        System.out.println(list.size());
    }

}
