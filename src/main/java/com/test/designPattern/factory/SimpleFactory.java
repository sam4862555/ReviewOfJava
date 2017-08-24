package com.test.designPattern.factory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by szh on 2017/8/10.
 */
public class SimpleFactory {

    private static List<String> ProductNameList = new ArrayList<>();

    static {
        try {
            //得到DOM解析器的工厂实例
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            //从DOM工厂中获得DOM解析器
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            //把要解析的xml文档读入DOM解析器
            Document doc = dbBuilder.parse("resource/xml/productList.xml");
            NodeList list = doc.getElementsByTagName("class");
            for (int i = 0; i < list.getLength(); i++) {
                Element j = (Element) list.item(i);
                String value = j.getAttribute("name");
//                if (value != null) {
//                    System.out.println(value);
//                }
                ProductNameList.add(value);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ProductPrototype GetProduct(String productName) {
        Boolean flag = false;
        for (String name : ProductNameList) {
            if (name.equals(productName)) {
                flag = true;
                break;
            }
        }
        if (!flag) return null;


        ProductPrototype instance = null;
        try {
            instance = (ProductPrototype) Class.forName("com.test.designPattern.factory." + productName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    public static void main(String[] args) {

        ProductPrototype a = GetProduct("ProductC");
        if (a != null) {
            a.AlreadyKnow();
        }

    }

}
