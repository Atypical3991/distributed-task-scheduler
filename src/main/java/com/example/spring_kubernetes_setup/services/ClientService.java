package com.example.spring_kubernetes_setup.services;

import com.example.spring_kubernetes_setup.components.CuratorFrameworkComponent;
import com.example.spring_kubernetes_setup.utils.ZKUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

@Slf4j
@Service
public class ClientService {

    @Autowired
    private CuratorFrameworkComponent curatorFrameworkComponent;

    public String registerJob(Runnable jobDetail) {
        String jobId = UUID.randomUUID().toString();
        syncCreate(ZKUtils.getJobsPath() + "/" + jobId, jobDetail);
        return jobId;
    }

    private void syncCreate(String path, Runnable runnable) {
        // create the ZNode along with the data
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(runnable);
            curatorFrameworkComponent.getCuratorFramework()
                    .create()
                    .idempotent()
                    .withMode(CreateMode.PERSISTENT)
                    .forPath(path, byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            log.error("Unable to create {}", path, e);
            throw new RuntimeException(e);
        }
    }
}