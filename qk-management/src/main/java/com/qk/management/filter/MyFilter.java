package com.qk.management.filter;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * @author 33465
 * @created 2026/4/24 上午9:24
 * @desciption
 */
//@WebFilter("/*")
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter 方法执行了...");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init 方法执行了...");
    }

    @Override
    public void destroy() {
        System.out.println("destroy 方法执行了...");
    }
}
   