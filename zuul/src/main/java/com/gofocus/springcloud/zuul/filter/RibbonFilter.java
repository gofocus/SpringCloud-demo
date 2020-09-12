package com.gofocus.springcloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: GoFocus
 * @Date: 2020-09-10 21:31
 * @Description: 老项目的路由映射到新服务的路由
 */
@Component
public class RibbonFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -100;
    }

    @Override
    public boolean shouldFilter() {
        //如果被限流，过滤器就不执行了
        return !(Boolean) RequestContext.getCurrentContext().get("limit");
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        String requestURI_ctx = (String) currentContext.get(FilterConstants.REQUEST_URI_KEY);
//        StringBuffer requestURL = request.getRequestURL();
//        String requestURI = request.getRequestURI();

/*        try {
            currentContext.setRouteHost(new URI("http://localhost:9001/hello").toURL());
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }*/

        if (requestURI_ctx.contains("/hello-old")) {
            requestURI_ctx = requestURI_ctx.replace("/hello-old", "/hello");
            currentContext.set(FilterConstants.REQUEST_URI_KEY, requestURI_ctx);
            // SERVICE_ID_KEY(服务名) 不能少！
            currentContext.set(FilterConstants.SERVICE_ID_KEY, "service-api-listener");
        }

        return null;
    }
}
