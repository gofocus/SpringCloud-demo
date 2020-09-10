package com.gofocus.springcloud.apilistener.api;

import com.gofocus.springcloud.apilistener.hystrix.HelloRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: GoFocus
 * @Date: 2020-09-01 13:30
 * @Description:
 */

@FeignClient(name = "service-producer", fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

    @RequestMapping("/helloRemote")
    public String hello(@RequestParam(value = "name") String name);

}


