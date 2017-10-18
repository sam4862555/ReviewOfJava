package com.test.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by szh on 2017/9/10.
 */
public class GetPostTest {

    public static void SendGetRequest(String urlString, Map<String, String> params) throws Exception {
        if (!params.isEmpty()) {
            urlString += "?";
        }
        for (String key : params.keySet()) {
            urlString = urlString + key + "=" + params.get(key) + "&";
        }
        int lastPos = urlString.lastIndexOf("&");
        String finalString = urlString.substring(0, lastPos);
        URL url = new URL(finalString);
        URLConnection urlConnection = url.openConnection();

        //1.设置通用的请求头
        urlConnection.setRequestProperty("accept", "*/*");
        urlConnection.setRequestProperty("connection", "Keep-Alive");

        //2.连接，注意此处只有Get请求中有
        urlConnection.connect();

        Map<String, List<String>> map = urlConnection.getHeaderFields();
        for (String key : map.keySet()) {
            System.out.println(key + " ----> " + map.get(key));
        }
        try {
            //3.获取响应的内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"utf-8"));
            String tmpLine = null;
            while( (tmpLine = reader.readLine()) != null){
                System.out.println(tmpLine);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void SendPostRequest(String urlString, Map<String, String> params) throws  Exception{

        URL url = new URL(urlString);
        URLConnection urlConnection = url.openConnection();

        //1.设置通用的请求头
        urlConnection.setRequestProperty("accept", "*/*");
        urlConnection.setRequestProperty("connection", "Keep-Alive");

        //2.Post请求特殊的地方
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);

        //3.拼接请求参数，并获取connection的OutputStream,把参数写进去
        try {
            PrintWriter writer = new PrintWriter(urlConnection.getOutputStream());
            String paramsString = new String();
            for (String key : params.keySet()) {
                paramsString = paramsString + key + "=" + params.get(key) + "&";
            }
            int lastPos = paramsString.lastIndexOf("&");
            String finalString = paramsString.substring(0, lastPos);
            writer.write(finalString);
            writer.flush();
        }catch (Exception e){
            e.printStackTrace();
        }

        Map<String, List<String>> map = urlConnection.getHeaderFields();
        for (String key : map.keySet()) {
            System.out.println(key + " ----> " + map.get(key));
        }
        try {
            //3.获取响应的内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"utf-8"));
            String tmpLine = null;
            while( (tmpLine = reader.readLine()) != null){
                System.out.println(tmpLine);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception{
        String requestUrl = "https://www.bing.com/search";
        Map<String, String> params = new HashMap<>();
        //q=ww、&pc=MOZD&form=MOZLBR
        params.put("q", "ww、");
        params.put("pc", "MOZD");
        params.put("form", "MOZLBR");
        //SendGetRequest(requestUrl, params);
        SendPostRequest(requestUrl,params);
    }
}
