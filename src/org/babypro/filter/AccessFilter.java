package org.babypro.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
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
        req.setAttribute("user_id","E18011112222");

        //// TODO: 11/6/2016 使用过滤器来进行用户判断还是使用拦截器进行用户判断??? 
        pFilterChain.doFilter(req,resp);

    }

    @Override
    public void destroy() {

    }
}
