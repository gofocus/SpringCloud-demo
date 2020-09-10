package com.gofocus.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

/**
 * @Author: GoFocus
 * @Date: 2020-09-06 18:59
 * @Description:
 */

//@Component
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
