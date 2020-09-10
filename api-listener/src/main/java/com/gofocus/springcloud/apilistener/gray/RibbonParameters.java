package com.gofocus.springcloud.apilistener.gray;

import org.springframework.stereotype.Component;

/**
 * @Author: GoFocus
 * @Date: 2020-09-09 18:43
 * @Description: 手动实现灰度发布时，通过这个 ThreadLocal 将用户信息传递给自定义负载均衡策略。
 */
@Component
public class RibbonParameters {

    private static final ThreadLocal tl = new ThreadLocal();

    public static <T> void set(T t) {
        tl.set(t);
    }

    public static <T> T get() {
        return (T) tl.get();
    }

}


