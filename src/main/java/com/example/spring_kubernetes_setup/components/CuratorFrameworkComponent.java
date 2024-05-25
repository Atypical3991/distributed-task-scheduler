package com.example.spring_kubernetes_setup.components;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.stereotype.Component;

@Component
public class CuratorFrameworkComponent {

    private final CuratorFramework curator;

    public CuratorFrameworkComponent() {
        curator = CuratorFrameworkFactory.builder().namespace("TaskSchedulerV0")
                // namespace is a must to avoid conflicts in shared zk clusters
                .connectString("127.0.0.1:2181").retryPolicy(new ExponentialBackoffRetry(10, 1)).build();
        curator.start();
    }

    public CuratorFramework getCuratorFramework() {
        return this.curator;
    }


}
