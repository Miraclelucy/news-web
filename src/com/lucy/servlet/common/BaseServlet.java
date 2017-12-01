package com.lucy.servlet.common;

import com.lucy.until.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @描述 如何在同一个servlet中处理多个请求呢？比如将Comment的CRUD整合到一个servlet还怎么做？
 * 公共的方法用于-传递到servlet时，带上method的参数，不同的参数执行不同的方法，这样就可以
 * @创建人 lushiqin
 * @创建时间 2017-11-25
 * @修改人和其它信息
 */
public class BaseServlet extends HttpServlet{

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException{
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse)servletResponse;
        String  method=StringUtil.null2String(req.getParameter("method"));
        //获取继承类的Class对象
        Class c=this.getClass();
        if("".equals(method)){
            //如果为空方法，执行默认的excute方法
            method="excute";
        }

        //如果不为空，则执行继承类中对应的该方法
        try {
            Method  m=c.getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
           String s=(String) m.invoke(this,req,resp);
           if(StringUtil.isNotEmpty(s)){
               req.getRequestDispatcher(s).forward(req,resp);
            }
        }
       catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }catch (ServletException e) {
            e.printStackTrace();
        }
    //可以将继承类中的方法都写成带有String返回值的，用来指定请求转发的页面。



    }

    public String excute(HttpServletRequest req,HttpServletResponse resp) throws IOException{
            return "/index.jsp";

    }


}
