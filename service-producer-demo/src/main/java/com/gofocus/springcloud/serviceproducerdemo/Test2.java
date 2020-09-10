package com.gofocus.springcloud.serviceproducerdemo;

import org.apache.lucene.util.RamUsageEstimator;

import java.util.HashMap;

/**
 * @Author: GoFocus
 * @Date: 2020-09-08 17:36
 * @Description:
 */
public class Test2 {

    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        RamUsageEstimator.shallowSizeOf(objectObjectHashMap);
        long byteCount = RamUsageEstimator.shallowSizeOf(objectObjectHashMap);

        double oneMb = 1 * 1024 * 1024;

        Double v = Double.valueOf(byteCount) / oneMb;
        System.out.println(v);
    }
}
