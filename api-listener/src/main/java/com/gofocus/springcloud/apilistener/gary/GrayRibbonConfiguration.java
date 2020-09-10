package com.gofocus.springcloud.apilistener.gary;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

/**
 * @Author: GoFocus
 * @Date: 2020-09-09 18:59
 * @Description:
 */
public class GrayRibbonConfiguration {

    @Bean
    public IRule ribbonRule() {
        return new GrayRule();
    }

}
