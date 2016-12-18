package org.babypro.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登陆过滤器
 * Created by johnzhu on 11/6/2016.
 */
public class AccessFilter implements Filter {

    @Override
    public void init(FilterConfig pFilterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest pServletRequest, ServletResponse pServletResponse, FilterChain pFilterChain) throws IOException, ServletException {

        System.out.println("----过滤器----");
        HttpServletRequest req = (HttpServletRequest) pServletRequest;
        HttpServletResponse resp = (HttpServletResponse) pServletResponse;

        String a = req.getHeader("open_id");
        System.out.println("------a ------"+a);
        req.setAttribute("open_id",a);

        //// TODO: 11/6/2016 使用过滤器来进行用户判断还是使用拦截器进行用户判断??? 
        pFilterChain.doFilter(req,resp);

    }

    @Override
    public void destroy() {

    }
}
