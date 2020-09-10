package com.gofocus.springcloud.zuul;

import com.netflix.discovery.util.RateLimiter;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;

/**
 * @Author: GoFocus
 * @Date: 2020-09-03 15:12
 * @Description:
 */


public class MsbFallBack implements FallbackProvider {
    @Override
    public String getRoute() {
//        return "service-api-listener";
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return null;
    }
}
