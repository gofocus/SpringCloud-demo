package com.gofocus.springcloud.apilistener;

import com.gofocus.springcloud.apilistener.gary.GrayRibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@RibbonClient(name = "service-producer",configuration = GrayRibbonConfiguration.class)
public class ApiListenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiListenerApplication.class, args);
    }

}

