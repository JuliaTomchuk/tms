package org.example;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class HeadersFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getMethod().equalsIgnoreCase("get")) {
            chain.doFilter(request, response);

        }
        String headerNames = req.getHeader("userName");

        if (headerNames == null || headerNames.isBlank()) {
            throw new ServletException("Enter userName");
        } else {
            chain.doFilter(request, response);
        }


    }

    @Override
    public void destroy() {

    }
}
