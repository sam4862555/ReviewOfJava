package com.test.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by szh on 2017/11/28.
 */
public class MapTest {

    public static void main(String[] args){
        Map<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"ox");
        hashMap.put(2,"ss");

        for( Map.Entry<Integer,String> tmp : hashMap.entrySet()){
            System.out.println("key : " + tmp.getKey() + "\n" + "value : " + tmp.getValue());
        }

    }

}
