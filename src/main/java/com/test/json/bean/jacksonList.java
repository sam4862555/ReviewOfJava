package com.test.json.bean;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by szh on 2017/11/2.
 */

class YourBean{
    public String id;
    public Long timestamp;
}

public class jacksonList {

    public final static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args){
        String jsonString = "[\n" +
                "                {\n" +
                "                    \"id\": \"288206077664983\",\n" +
                "                    \"timestamp\": 1371052476\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"186983078111768\",\n" +
                "                    \"timestamp\": 1370944068\n" +
                "                }, {\n" +
                "                    \"id\": \"297031120529307\",\n" +
                "                    \"timestamp\": 1370751789\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": \"273831022294863\",\n" +
                "                    \"timestamp\": 1369994812\n" +
                "                }]";
        try {
            JavaType javaType = getCollectionType(ArrayList.class, YourBean.class);
            List<YourBean> list = (List<YourBean>) mapper.readValue(jsonString, javaType);
            System.out.println("list size : " + list.size());

            for(int i =0 ; i<list.size(); i++){
                System.out.println("id : " + list.get(i).id + "\n" + "timestamp : " + list.get(i).timestamp + "\n");
            }

        }catch (JsonMappingException e){
            System.out.println(e.getMessage());
        }catch (IOException s){
            s.printStackTrace();
        }
    }

    /**
     * 获取泛型的Collection Type
     *
     * @param collectionClass 泛型的Collection
     * @param elementClasses  元素类
     * @return JavaType Java类型
     * @since 1.0
     */
    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
