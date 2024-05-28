package com.example.distributed_task_scheduler.models.entities;

import com.example.distributed_task_scheduler.models.entities.enums.JobStatusEnum;
import com.example.distributed_task_scheduler.models.entities.listeners.JobEntityListener;
import com.example.distributed_task_scheduler.tasks.TaskEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

import static com.example.distributed_task_scheduler.utils.DateUtil.getCurrentISTTime;

@EntityListeners(JobEntityListener.class)
@Entity
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobId;

    private String workerId;

    @Enumerated(EnumType.STRING)
    private TaskEnum taskName;

    private String taskArgs;

    @Enumerated(EnumType.STRING)
    private JobStatusEnum status = JobStatusEnum.CREATED;

    private LocalDateTime createdAt = getCurrentISTTime();

    private LocalDateTime updatedAt = getCurrentISTTime();

}
