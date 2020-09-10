package com.gofocus.springcloud.apilistener.gray;

import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 马士兵教育:晁鹏飞
 * @date
 * 拦截请求，进行灰度发布
 */
@Aspect
@Component
public class RequestAspect {

    @Pointcut("execution(* com.gofocus.springcloud.apilistener.controller..*Controller*.*(..))")
    private void anyMethod(){
    }

    @Before(value = "anyMethod()")
    public void before(JoinPoint joinPoint){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String version = request.getHeader("version");

        //指定服务的metadata应该有哪些信息，jmnarloch 会找到这样的服务并把请求负载均衡过去。
        RibbonFilterContextHolder.getCurrentContext().add("version", version);
        //用了 jmnarloch 就不需要ThreadLocal了，也不需要自己去获取服务的metadata了，jmnarloch会帮你搞定。

//        Map<String,String> map = new HashMap<>();
//        map.put("version",version);
//        RibbonParameters.set(map);

    }
}
