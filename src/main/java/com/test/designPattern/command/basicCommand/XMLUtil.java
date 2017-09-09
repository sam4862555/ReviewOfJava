package com.test.designPattern.command.basicCommand;

/**
 * Created by szh on 2017/8/26.
 */

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLUtil {

    //该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象，可以通过参数的不同返回不同类名
    public static Object getBean(int i) {
        try {
            //创建文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("resource/xml/commandPattern.xml"));
            //获取包含类名的文本节点
            NodeList nl = doc.getElementsByTagName("className");
            Node classNode = null;
            if (0 == i) {
                classNode = nl.item(0).getFirstChild();
            } else {
                classNode = nl.item(1).getFirstChild();
            }
            String cName = classNode.getNodeValue();
            //通过类名生成实例对象并将其返回
            Class c = Class.forName("com.test.designPattern.command.basicCommand." + cName);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}