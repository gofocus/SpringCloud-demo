package com.gofocus.springcloud.zuul.controller;

import com.gofocus.springcloud.zuul.yml.MyYml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: GoFocus
 * @Date: 2020-09-10 17:20
 * @Description:
 */

@RestController
public class MyController {

    @Autowired
    private MyYml myYml;

    @GetMapping("/myController")
    public String myController() {
        return "forward to zuul" + "eve：" + myYml.getEve();
    }
}
