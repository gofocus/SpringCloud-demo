package com.gofocus.springcloud.apilistener.gray;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: GoFocus
 * @Date: 2020-09-09 18:59
 * @Description: 将自定义的负载均衡策略交给容器
 */
public class GrayRibbonConfiguration {

    @Bean
    public IRule ribbonRule() {
        return new GrayRule();
    }

}
