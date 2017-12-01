package com.lucy.dao.demo;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @描述
 * @创建人 lushiqin
 * @创建时间 2017-11-05
 * @修改人和其它信息
 */
public class Dom4jDemo {
    /**
     *@描述 
     *@参数  
     *@返回值  
     *@创建人  lushiqin
     *@创建时间  2017-11-05
     *@修改人和其它信息
     */
    public static void main(String[] args) throws  Exception{
        SAXReader read=new SAXReader();
        Document  doc=read.read("D:\\MyEclipse2015_workplace_3\\newsweb\\WebRoot\\WEB-INF\\web.xml");
        Element root=doc.getRootElement();
        List<Element> elementList=root.elements();
        for(Element e:elementList){
            String text=e.elementText("servlet-name");
            System.out.println(text);
        }


    }

}
