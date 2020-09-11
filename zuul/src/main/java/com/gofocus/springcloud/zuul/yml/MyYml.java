package com.gofocus.springcloud.zuul.yml;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: GoFocus
 * @Date: 2020-09-11 9:16
 * @Description: 获取配置文件的属性
 */

@PropertySource(value = {"classpath:application.yml"})
@ConfigurationProperties(prefix = "test")
@Component
public class MyYml {

    @Value("${eve}")
    String eve;

    public String getEve() {
        return eve;
    }
}
