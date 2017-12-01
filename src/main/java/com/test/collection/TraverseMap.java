package com.test.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by szh on 2017/11/9.
 */
public class TraverseMap {

    public static void main(String[] args){

        Map<Integer, String> namesMap = new HashMap<>();
        namesMap.put(1,"szh");
        namesMap.put(2,"sfj");

        Set<Map.Entry<Integer, String>> set = namesMap.entrySet();
        for(Map.Entry s : set){
            System.out.println("Key :" + s.getKey() + "\n" + "Value : "+ s.getValue());
        }
    }

}
