package com.example.distributed_task_scheduler.models.entities;

import com.example.distributed_task_scheduler.models.entities.enums.JobStatusEnum;
import com.example.distributed_task_scheduler.tasks.TaskEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String workerId;

    @Enumerated(EnumType.STRING)
    private TaskEnum taskName;

    private String taskArgs;

    @Enumerated(EnumType.STRING)
    private JobStatusEnum status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
