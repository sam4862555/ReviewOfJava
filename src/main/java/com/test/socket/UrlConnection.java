package com.test.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by szh on 2017/9/10.
 */
public class UrlConnection {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.baidu.com/");
        System.out.println("URL 的主机地址是" + url.getHost() + "\nURL 的路径是" + url.getPath());
        HttpURLConnection urlConnection  = (HttpURLConnection) url.openConnection();

        urlConnection.connect();
        System.out.println("请求的方式是"+urlConnection.getRequestMethod());
        System.out.println("返回的状态"+urlConnection.getResponseMessage());
        System.out.println("返回的状态码"+urlConnection.getResponseCode());
        System.out.println("返回的页面大小"+urlConnection.getContentLength());
        InputStream stream = urlConnection.getInputStream();
        InputStreamReader rstream = new InputStreamReader(stream, Charset.forName("utf-8"));
        BufferedReader reader = new BufferedReader(rstream);
        String tmpLine = null;
        while( (tmpLine = reader.readLine()) != null){
            System.out.println(tmpLine);
        }
        urlConnection.disconnect();
    }
}
