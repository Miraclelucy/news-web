package com.lucy.servlet.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResolveNews {
	/** 
     * 读取网页全部内容 
     */ 
    public String getHtmlContent(String htmlurl) { 
        URL url; 
        String temp; 
        StringBuffer sb = new StringBuffer(); 
        try { 
            url = new URL(htmlurl); 
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));// 读取网页全部内容
            while ((temp = in.readLine()) != null) { 
                sb.append(temp).append("\n"); 
            } 
            in.close(); 
        } catch (final MalformedURLException me) { 
            System.out.println("你输入的URL格式有问题!"); 
            me.getMessage(); 
        } catch (final IOException e) { 
            e.printStackTrace(); 
        } 
        return sb.toString(); 
    } 
 
    /** 
     * 
     * @param s 
     * @return 获得网页标题 
     */ 
    public String getTitle(String s) { 
        String regex; 
        String title = ""; 
        List<String> list = new ArrayList<String>(); 
        regex = "<title>.*?</title>"; 
        Pattern pa = Pattern.compile(regex, Pattern.CANON_EQ); 
        Matcher ma = pa.matcher(s); 
        while (ma.find()) { 
            list.add(ma.group()); 
        } 
        for (int i = 0; i < list.size(); i++) { 
            title = title + list.get(i); 
        } 
        return outTag(title); 
    } 
    
    /** 
     * 
     * @param s 
     * @return 去掉标记 
     */ 
    public String outTag(final String s) { 
        return s.replaceAll("<.*?>", ""); 
    } 
    
    /** 
     * 
     * @param s 
     * @return 获得链接 
     */ 
    public List<String> getLink(String s) { 
        String regex; 
        List<String> list = new ArrayList<String>(); 
        regex = "<a[^>]*href=(\"([^\"]*)\"|\'([^\']*)\'|([^\\s>]*))[^>]*>(.*?)</a>"; 
        Pattern pa = Pattern.compile(regex, Pattern.DOTALL); 
        Matcher ma = pa.matcher(s); 
        while (ma.find()) { 
            list.add(ma.group()); 
        } 
        return list; 
    } 
    
    /** 
     * 
     * @param s 
     * @return 获得新闻内容
     */ 
    public List<String> getNews(String s) { 
        String regex = "<p.*?</p>"; 
        Pattern pa = Pattern.compile(regex, Pattern.DOTALL); 
        Matcher ma = pa.matcher(s); 
        List<String> list = new ArrayList<String>(); 
        while (ma.find()) { 
            list.add(ma.group()); 
        } 
        return list; 
    } 
}
