package com.gofocus.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: GoFocus
 * @Date: 2020-09-09 10:03
 * @Description:
 */

@Component
public class GrayFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext currentContext = RequestContext.getCurrentContext();
        String proxy = (String) currentContext.get("proxy");
        HttpServletRequest request = currentContext.getRequest();
        String userId = request.getHeader("userId");
        if ("1".equals(userId) && "service-api-listener".equals(proxy)) {
            RibbonFilterContextHolder.getCurrentContext().add("version", "v88");
        } else {
            RibbonFilterContextHolder.getCurrentContext().remove("version");
        }

        return null;
    }
}
