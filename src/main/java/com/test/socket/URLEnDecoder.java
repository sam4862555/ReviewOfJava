package com.test.socket;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by szh on 2017/9/10.
 */
public class URLEnDecoder {
    public static void main(String[] args) throws Exception {
        String result = URLDecoder.decode("https://search.jd.com/Search?keyword=%E5%AE%9D%E5%85%B8&enc=utf-8&wq=bao%27dian&pvid=5dd2651f786949488734d6800c5ac001", "utf-8");
        System.out.println("解码后的结果为 : " + result);
        String encodeResult = URLEncoder.encode("仅仅是做个测试", "UTF-8");
        System.out.println("加码后的结果为 : " + encodeResult);
    }
}
