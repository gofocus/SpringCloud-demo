package com.gofocus.springcloud.apilistener.gary;

import org.springframework.stereotype.Component;

/**
 * @Author: GoFocus
 * @Date: 2020-09-09 18:43
 * @Description:
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
