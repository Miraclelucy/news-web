package com.lucy.filter;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.servlet.*;
import java.io.IOException;

/**
 * @描述
 * @创建人 lushiqin
 * @创建时间 2017-11-18
 * @修改人和其它信息
 */
public class AFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("A   get request!!");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("A   get response  !!");

    }

    @Override
    public void destroy() {

    }
}
