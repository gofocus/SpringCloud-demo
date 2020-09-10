package com.gofocus.springcloud.serviceproducerdemo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: GoFocus
 * @Date: 2020-09-01 13:37
 * @Description:
 */

@RestController
public class HelloController {

    @Value("${spring.profiles}")
    String producerName;

    @Value("${server.port}")
    String port;

    @GetMapping("/helloRemote")
    public String hello(@RequestParam(value = "name") String name) {
        return "Hello" + name + ", you just called a remote service!" + "(" + producerName + ":" + port + ")";
    }

}
