package org.xumak.camunda.spring.configuration;

import javax.servlet.*;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xumak on 14/09/16.
 */
public class CORSFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filtering on ...................................................................");
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        filterChain.doFilter(req, res);
    }

    public void destroy() {

    }
}
