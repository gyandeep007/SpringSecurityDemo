package com.gyan.customerservice.customerservice.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class CustomFilter implements Filter {
    private final Log log = LogFactory.getLog(this.getClass());
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Assert.isTrue(servletRequest instanceof HttpServletRequest,"this assumes you have an HTTP request");
        HttpServletRequest httpServletRequest = HttpServletRequest.class.cast(servletRequest);
        String requestURI = httpServletRequest.getRequestURI();
        log.info("new request for "+requestURI);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
