package com.example.distributed_task_scheduler.models.entities.listeners;

import com.example.distributed_task_scheduler.models.entities.Job;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

import static com.example.distributed_task_scheduler.utils.DateUtil.getCurrentISTTime;

public class JobEntityListener {

    @PrePersist
    public void setCreatedAtAndUpdatedAt(Job entity) {
        LocalDateTime now = getCurrentISTTime();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);
    }

    @PreUpdate
    public void setUpdatedAt(Job entity) {
        entity.setUpdatedAt(getCurrentISTTime());
    }
}
