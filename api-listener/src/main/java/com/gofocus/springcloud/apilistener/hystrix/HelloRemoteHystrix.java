package com.gofocus.springcloud.apilistener.hystrix;

import com.gofocus.springcloud.apilistener.api.HelloRemote;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: GoFocus
 * @Date: 2020-09-04 17:21
 * @Description:
 */

@Component
public class HelloRemoteHystrix implements HelloRemote {

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "降级啦！";
    }
}
