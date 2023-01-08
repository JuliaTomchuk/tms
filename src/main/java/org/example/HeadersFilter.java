package org.example;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
@WebFilter("/*")
public class HeadersFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       if(((HttpServletRequest) request).getMethod().equalsIgnoreCase("get")){
            chain.doFilter(request,response);

        }
        String headerNames= ((HttpServletRequest)request).getHeader("userName");

        if(headerNames==null){
            throw new ServletException("Enter userName");
        }else{ chain.doFilter(request,response);}



   }

    @Override
    public void destroy() {

    }
}
