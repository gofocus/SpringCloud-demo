package com.gofocus.springcloud.apilistener.filter;


import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: GoFocus
 * @Date: 2020-09-11 17:16
 * @Description: 服务限流
 */
@Component
public class LimitingFilter implements Filter {

    private static final RateLimiter RATE_LIMITER = RateLimiter.create(1);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (RATE_LIMITER.tryAcquire()) {
            chain.doFilter(request, response);
        } else {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter pw = response.getWriter();
            pw.write("限流了");
            pw.close();
        }
    }

    @Override
    public void destroy() {

    }
}
