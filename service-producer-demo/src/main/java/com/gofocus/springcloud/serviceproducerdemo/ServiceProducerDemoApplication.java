package com.gofocus.springcloud.serviceproducerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient
@SpringBootApplication
public class ServiceProducerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProducerDemoApplication.class, args);
    }

}
