package com.lucy.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @描述
 * @创建人 lushiqin
 * @创建时间 2017-11-20
 * @修改人和其它信息
 */
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse  response=(HttpServletResponse)servletResponse;
        //利用动态代理的方式

        HttpServletRequest requestProxy=(HttpServletRequest) Proxy.newProxyInstance(HttpServletRequest.class.getClassLoader(),
                request.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        if("getParameter".equals(method.getName())){
                            String type=request.getMethod();//请求方式
                            if("get".equalsIgnoreCase(type)){
                                String str=(String)method.invoke(request,args);
                                if(str!=null){
                                    return new String(str.getBytes("iso8859-1"),"utf-8");
                                }

                            } else if("post".equalsIgnoreCase(type)){
                                request.setCharacterEncoding("utf-8");
                                return method.invoke(request,args);
                            }

                        }

                        return method.invoke(request,args);
                    }
                });

        //放行
        filterChain.doFilter(requestProxy,response);


    }

    @Override
    public void destroy() {

    }
}
