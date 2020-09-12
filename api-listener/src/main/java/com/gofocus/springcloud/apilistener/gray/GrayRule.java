package com.gofocus.springcloud.apilistener.gray;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.loadbalancer.DiscoveryEnabledServer;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Author: GoFocus
 * @Date: 2020-09-09 17:18
 * @Description: 手动实现灰度发布时的自定义负载均衡策略，如果使用 jmnarloch 则不需要。
 */

public class GrayRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    private Server choose(ILoadBalancer iLoadBalancer, Object key) {
        //获取用户的 metadata
        // TODO 为什么用 Feign 进行服务调用时 ThreadLocal 一直为空？ 用 RestTemplate 没问题
        Map<String, String> map = RibbonParameters.get();
        String version = "";
        if (map != null && map.containsKey("version")) {
            version = map.get("version");
        }

        //获取所有可用的节点
        List<Server> allServers = iLoadBalancer.getAllServers();
        //遍历所有节点
        for (Server server : allServers) {
            //拿到节点的自定义数据
            Map<String, String> metadata = ((DiscoveryEnabledServer) server).getInstanceInfo().getMetadata();

            //与灰度规则做匹配
            if (metadata.containsKey("version")) {
                String metaVersion = metadata.get("version");
                if (metaVersion.trim().equals(version)) {
                    return server;
                }
            }
        }

        return allServers.get(new Random().nextInt(allServers.size()));
    }
}
