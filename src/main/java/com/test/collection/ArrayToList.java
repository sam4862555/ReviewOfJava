package com.test.collection;

import java.util.Arrays;
import java.util.List;

/**
 * Created by szh on 2017/11/9.
 */
public class ArrayToList {

    public static void main(String[] args){

        String[] names= {"bob","dp","ssw","faker"};

        List<String> nameList = Arrays.asList(names);
        nameList.add("kk");

    }
}
