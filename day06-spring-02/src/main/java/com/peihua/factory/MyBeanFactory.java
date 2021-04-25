package com.peihua.factory;


import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建自己的工厂类
 */
public class MyBeanFactory {
    private static Map<String,Object> map=new HashMap<>();

    static {
        //首先需要一个解析器
        try {
            SAXReader reader = new SAXReader();
            //读取核心配置文件
            String path = "src\\main\\resources\\applocationContext.xml";
            //读取整个文档对象
            Document document = reader.read(path);
            //获得根节点 beans
            Element element = document.getRootElement();
            //获得根节点下所有bean的节点
            List<Element> bean = element.elements("bean");
            //List<Element> bean = element.elements("bean");
            for (Element element1 : bean) {
                String id = element1.attributeValue("id");
                String aClass = element1.attributeValue("class");
                //通过反射创建对象
                Class  clz = Class.forName(aClass);

                Object object = clz.newInstance();

                //存放在容器中
                map.put(id,object);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    public static Object getBean(String id){
        Object o = map.get(id);
        return o;
    }
}
