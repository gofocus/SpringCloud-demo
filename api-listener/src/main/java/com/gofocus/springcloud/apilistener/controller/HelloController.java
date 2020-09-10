package com.gofocus.springcloud.apilistener.controller;

import com.gofocus.springcloud.apilistener.api.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: GoFocus
 * @Date: 2020-09-01 13:32
 * @Description:
 */

@RestController
public class HelloController {

    @Autowired
    private HelloRemote helloRemote;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String port;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        String url = "http://" + "service-producer" + "/helloRemote?name=gofocus!!!";
        return restTemplate.getForObject(url, String.class);
//        return helloRemote.hello(name) + port;
    }
}
