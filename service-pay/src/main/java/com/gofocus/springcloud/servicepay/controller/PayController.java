package com.gofocus.springcloud.servicepay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: GoFocus
 * @Date: 2020-09-12 14:17
 * @Description:
 */

@RestController
public class PayController {

    @GetMapping("/")
    public String pay() {
        return "this is payController";
    }
}
