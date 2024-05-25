package com.example.spring_kubernetes_setup.controllers;


import com.example.spring_kubernetes_setup.components.CuratorFrameworkComponent;
import com.example.spring_kubernetes_setup.utils.ZKUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RequestMapping("/v1/jobs")
@RestController
public class JobController {

    private final CuratorFrameworkComponent curatorFrameworkComponent;

    @Autowired
    public JobController(CuratorFrameworkComponent curatorFrameworkComponent) {
        this.curatorFrameworkComponent = curatorFrameworkComponent;
    }


    @PostMapping("/process-job")
    public void createJob(String jobData) {
        log.info("Received job {}", jobData);
        try {
            curatorFrameworkComponent.getCuratorFramework()
                    .create()
                    .withMode(CreateMode.PERSISTENT)
                    .forPath(ZKUtils.getJobsPath() + "/" + UUID.randomUUID(), jobData.getBytes());
        } catch (Exception e) {
            log.error("Unable to submit job", e);
            throw new RuntimeException(e);
        }
    }
}
