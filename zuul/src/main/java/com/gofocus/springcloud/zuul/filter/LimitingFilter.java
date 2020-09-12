package com.gofocus.springcloud.zuul.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


/**
 * @Author: GoFocus
 * @Date: 2020-09-11 16:20
 * @Description: 使用 Guava的令牌桶做限流
 */
@Component
public class LimitingFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -100;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 每秒10个令牌
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(10);

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        boolean tryAcquire = RATE_LIMITER.tryAcquire();

        if (!tryAcquire) {
            ctx.set("limit", true);
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
        } else {
            ctx.set("limit",false);
        }

        return null;
    }
}
