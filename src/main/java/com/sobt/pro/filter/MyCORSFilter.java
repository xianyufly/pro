package com.sobt.pro.filter;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyCORSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    
    /**
     * 本地调试开启跨域
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url=request.getHeader("Origin");
        if(url!=null){
            int index=url.indexOf("/", 7);
            if(index==-1){
                url=url;
            }else{
                url=url.substring(0, index);
            }
            List<String> path=new ArrayList<>();
            //授权域
            path.add("http://localhost:12000");
            path.add("http://localhost:3000");
            path.add("http://localhost");
            if(path.contains(url)){
                response.setHeader("Access-Control-Allow-Origin", url);
                response.setHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
                response.setHeader("Access-Control-Max-Age", "3600");
                response.setHeader("Access-Control-Allow-Headers", "Authorization,Content-Type");
                response.setHeader("Access-Control-Allow-Credentials","true");
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
