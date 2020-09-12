package com.gofocus.springcloud.serviceorder.controller;

import com.gofocus.springcloud.serviceorder.dao.OrderEventCustomDao;
import generate.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: GoFocus
 * @Date: 2020-09-12 14:23
 * @Description:
 */

@RestController
public class OrderController {

    @Autowired
    private OrderEventCustomDao orderEventCustomDao;

    @GetMapping("/")
    public String order() {
        return "this is order Controller";
    }
}
