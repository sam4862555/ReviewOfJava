package com.test.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.json.bean.JSONAge;

/**
 * Created by szh on 2017/10/31.
 */
public class jacksonTest2 {

   static String jsonStr = "{\n" +
           "        \"code\": 200,\n" +
           "        \"desc\": \"success\",\n" +
           "        \"data\": {\n" +
           "            \"area\": [\n" +
           "                {\n" +
           "                    \"name\": \"福建省\",\n" +
           "                    \"count\": 1798\n" +
           "                }\n" +
           "            ],\n" +
           "            \"oneDayAvgActive\": [\n" +
           "                {\n" +
           "                    \"duration\": \"00\",\n" +
           "                    \"count\": 7.49\n" +
           "                }\n" +
           "            ],\n" +
           "            \"insightName\": \"1010_merge1\",\n" +
           "            \"car\": {\n" +
           "                \"y\": {\n" +
           "                    \"p\": 33.72,\n" +
           "                    \"r\": 1,\n" +
           "                    \"c\": 6113\n" +
           "                }\n" +
           "            },\n" +
           "            \"city\": [\n" +
           "                {\n" +
           "                    \"coverage\": 5.77,\n" +
           "                    \"name\": \"北京市\",\n" +
           "                    \"rank\": 1,\n" +
           "                    \"active\": 5.76\n" +
           "                }\n" +
           "            ],\n" +
           "\n" +
           "            \"sex\": {\n" +
           "                \"w\": {\n" +
           "                    \"p\": 42.31,\n" +
           "                    \"r\": 2,\n" +
           "                    \"c\": 5690\n" +
           "                }\n" +
           "                ,\n" +
           "                \"m\": {\n" +
           "                    \"p\": 57.69,\n" +
           "                    \"r\": 1,\n" +
           "                    \"c\": 7758\n" +
           "                }\n" +
           "            }\n" +
           "            ,\n" +
           "            \"marry\": {\n" +
           "                \"y\": {\n" +
           "                    \"p\": 69.07,\n" +
           "                    \"r\": 1,\n" +
           "                    \"c\": 12521\n" +
           "                }\n" +
           "            }\n" +
           "            ,\n" +
           "            \"behaviorPrefer\": [\n" +
           "                {\n" +
           "                    \"activeCount\": 11352,\n" +
           "                    \"TGI\": 286,\n" +
           "                    \"name\": \"网上商城\",\n" +
           "                    \"percent\": 94.46\n" +
           "                }\n" +
           "            ],\n" +
           "            \"totalCount\": 18128,\n" +
           "            \"brand\": [\n" +
           "                {\n" +
           "                    \"name\": \"小米\",\n" +
           "                    \"value\": 4784,\n" +
           "                    \"percent\": 25.44\n" +
           "                }\n" +
           "            ],\n" +
           "            \"age\": {\n" +
           "                \"value\": [\n" +
           "                    291,\n" +
           "                    2502,\n" +
           "                    7425,\n" +
           "                    2228,\n" +
           "                    489,\n" +
           "                    99\n" +
           "                ],\n" +
           "                \"key\": [\n" +
           "                    \"<19 岁\",\n" +
           "                    \"19-25 岁\",\n" +
           "                    \"26-35 岁\",\n" +
           "                    \"36-45 岁\",\n" +
           "                    \"46-55 岁\",\n" +
           "                    \">55 岁\"\n" +
           "                ]\n" +
           "            }\n" +
           "        }\n" +
           "    }";


   public static void main(String[] args){
       try {
           ObjectMapper mapper = new ObjectMapper();
           JsonNode root = mapper.readTree(jsonStr);


           JsonNode responseCode = root.path("code");
           System.out.println("code  : " + responseCode.asInt());


           JsonNode desc = root.path("desc");
           System.out.println("desc : " + desc.asText());

           JsonNode dataOld = root.path("data");
           System.out.println("data : " + dataOld.toString());


           String dataString = dataOld.toString();
           ObjectMapper dataMapper = new ObjectMapper();
           JsonNode dataNode = dataMapper.readTree(dataString);

           //TODO : 测试代码
           System.out.println("whether data has property age :" + dataNode.has("age"));
           System.out.println("whether data has property kk :" + dataNode.has("kk"));

           JSONAge attrAge = null;
           if(dataNode.has("age")){
               JsonNode ageNode = dataNode.path("age");
               ObjectMapper mapperToJSONAge = new ObjectMapper();
               attrAge = mapper.readValue(ageNode.toString(), JSONAge.class);

               //打印
               String[] key = attrAge.getKey();
               if(null != key){
                   System.out.println("key.length  : "+ key.length );
                   for(int i=0; i< key.length; i++){
                       System.out.println("key : " + key[i]);
                   }
               }

               Integer[] value = attrAge.getValue();
               if(null != value){
                   System.out.println("value.length  : "+ value.length );
                   for(int i=0; i< value.length; i++){
                       System.out.println("value : " + value[i]);
                   }
               }
           }

       } catch (Exception e) {
           e.printStackTrace();
       }
   }


}
