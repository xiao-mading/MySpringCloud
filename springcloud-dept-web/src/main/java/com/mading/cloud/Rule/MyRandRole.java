package com.mading.cloud.Rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 需求，在轮询算法的基础上，每台服务器调用5次
 */
public class MyRandRole extends AbstractLoadBalancerRule {

    private int total = 5;
    private int currentIndex = 0;//当前提供服务的机器号

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }


    public Server choose(ILoadBalancer lb, Object key) {

        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

            if (total < 5) {
                server = upList.get(currentIndex);
                total++;
            } else {
                total = 0;
                if (++currentIndex >= upList.size()) {
                    currentIndex = 0;
                }
            }

//            int index = rand.nextInt(serverCount);
//            server = upList.get(index);

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    
    }

    //适配器？
    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

}
