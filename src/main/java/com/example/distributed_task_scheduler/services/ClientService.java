package com.example.distributed_task_scheduler.services;

import com.example.distributed_task_scheduler.DTOs.job.JobDetail;
import com.example.distributed_task_scheduler.utils.ZKUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
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
    private CuratorFramework curatorFramework;

    public String registerJob(JobDetail jobDetail) {
        String jobId = UUID.randomUUID().toString();
        jobDetail.setJobId(jobId);
        syncCreate(ZKUtils.getJobsPath() + "/" + jobId, jobDetail);
        return jobId;
    }

    private void syncCreate(String path, JobDetail jobDetail) {
        // create the ZNode along with the data
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(jobDetail);
            curatorFramework.create().idempotent().withMode(CreateMode.PERSISTENT).forPath(path, byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            log.error("Unable to create {}", path, e);
            throw new RuntimeException(e);
        }
    }
}