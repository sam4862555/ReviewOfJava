package com.test.io;

        import java.nio.charset.Charset;
        import java.util.SortedMap;

/**
 * Created by szh on 2017/9/9.
 */
public class CharsetTest {

    public static void main(String[] args) {
        SortedMap<String, Charset> map = Charset.availableCharsets();
        for (String key : map.keySet()) {
            System.out.println("Charset Name : " + key + " Value : " + map.get(key));
        }
    }

}
