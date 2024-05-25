package com.example.distributed_task_scheduler.components;

import com.example.distributed_task_scheduler.services.WorkerService;
import com.example.distributed_task_scheduler.utils.ZKUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Value("${zk.server}")
    private String zkServerConnectionString;

    @Value("${zk.exponential_backoff_retry.max_retry}")
    private int exponentialBackoffRetryMaxRetry;

    @Value("${zk.exponential_backoff_retry.sleep_time}")
    private int exponentialBackoffRetrySleepTime;

    @Value("${zk.namespace}")
    private String zkNameSpace;


    @Bean
    public CuratorFramework getCuratorFrameworkClient() {
        System.out.println(zkServerConnectionString);
        System.out.println(exponentialBackoffRetryMaxRetry);
        System.out.println(exponentialBackoffRetrySleepTime);
        System.out.println(zkNameSpace);
        CuratorFramework curator = CuratorFrameworkFactory.builder().namespace(zkNameSpace)
                // namespace is a must to avoid conflicts in shared zk clusters
                .connectString(zkServerConnectionString).retryPolicy(new ExponentialBackoffRetry(exponentialBackoffRetrySleepTime, exponentialBackoffRetryMaxRetry)).build();
        curator.start();
        return curator;
    }

    @Bean
    public WorkerService getWorkerService() {
        return new WorkerService(getCuratorFrameworkClient(), ZKUtils.LEADER_ROOT);
    }
}
