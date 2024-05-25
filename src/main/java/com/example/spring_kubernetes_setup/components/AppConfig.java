package com.example.spring_kubernetes_setup.components;

import com.example.spring_kubernetes_setup.services.WorkerService;
import com.example.spring_kubernetes_setup.utils.ZKUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CuratorFramework getCuratorFrameworkClient() {
        CuratorFramework curator = CuratorFrameworkFactory.builder().namespace("TaskSchedulerV0")
                // namespace is a must to avoid conflicts in shared zk clusters
                .connectString("127.0.0.1:2181").retryPolicy(new ExponentialBackoffRetry(10, 1)).build();
        curator.start();
        return curator;
    }

    @Bean
    public WorkerService getWorkerService() {
        return new WorkerService(getCuratorFrameworkClient(), ZKUtils.LEADER_ROOT);
    }
}
