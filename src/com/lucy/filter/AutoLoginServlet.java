package com.lucy.filter;

import com.lucy.dao.AdminDao;
import com.lucy.until.CookieUtils;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @描述
 * @创建人 lushiqin
 * @创建时间 2017-11-18
 * @修改人和其它信息
 */
public class AutoLoginServlet implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取cookie中autologin的值，如果不为空，这取出来和数据库中用户名密码校验，校验成功则将放入session中
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;


        //判断session中是否有值
        Object obj=request.getSession().getAttribute("adminName");
        if (obj==null){//没有用户时，才进行登录
            String path=request.getRequestURI();
            if(!path.contains("/adminLogin")){
                Cookie[] cookies=request.getCookies();
                if(cookies!=null){

                    Cookie  c= CookieUtils.getCookieByName("autologin",cookies);
                    if(c!=null){
                        String[] str=c.getValue().split("-");
                        String name=str[0];
                        String pwd=str[1];
                        AdminDao admin=new AdminDao();
                        boolean flag=admin.checkAdmin(name,pwd);
                        if(flag){
                            request.getSession().setAttribute("adminName",name);
                        }
                        System.out.println("自动登录成功"+name);
                    }
                }


            }


        }


        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}

