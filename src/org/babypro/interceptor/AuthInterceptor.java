package org.babypro.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截
 * Created by apple on 2016/11/14.
 */
public class AuthInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest pHttpServletRequest, HttpServletResponse pHttpServletResponse, Object pO) throws Exception {
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest pHttpServletRequest, HttpServletResponse pHttpServletResponse, Object pO, ModelAndView pModelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest pHttpServletRequest, HttpServletResponse pHttpServletResponse, Object pO, Exception pE) throws Exception {

    }
}
