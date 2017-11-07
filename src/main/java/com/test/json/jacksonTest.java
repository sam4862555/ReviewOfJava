package com.test.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by szh on 2017/10/31.
 */
public class jacksonTest {

    public static void main(String[] args){

        try
        {
            String str = "{\"data\":{\"birth_day\":7,\"birth_month\":6},\"errcode\":0,\"msg\":\"ok\",\"ret\":0}";

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(str);

            JsonNode data = root.path("data");

            JsonNode birth_day = data.path("birth_day");
            System.out.println(birth_day.asInt());

            JsonNode birth_month = data.path("birth_month");
            System.out.println(birth_month.asInt());

            JsonNode msg = root.path("msg");
            System.out.println(msg.textValue());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



    }

}
