package com.example.distributed_task_scheduler.models.entities;

import com.example.distributed_task_scheduler.models.entities.enums.WorkerStatusEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String workerId;

    private String currentJobId;

    private Boolean isLeader;

    @Enumerated(EnumType.STRING)
    private WorkerStatusEnum status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}