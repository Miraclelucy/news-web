package com.lucy.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @描述
 * @创建人 lushiqin
 * @创建时间 2017-11-18
 * @修改人和其它信息
 */
public class BFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("B   get request!!");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("B  get response  !!");
    }

    @Override
    public void destroy() {

    }
}
