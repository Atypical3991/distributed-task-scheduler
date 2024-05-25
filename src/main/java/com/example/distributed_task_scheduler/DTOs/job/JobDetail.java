package com.example.distributed_task_scheduler.DTOs.job;

import com.example.distributed_task_scheduler.DTOs.task.TaskArgs;
import com.example.distributed_task_scheduler.tasks.TaskEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class JobDetail implements Serializable {
    @JsonProperty("jobId")
    private String jobId;
    @JsonProperty("taskArgs")
    private TaskArgs taskArgs;
    @JsonProperty("taskEnum")
    private TaskEnum taskEnum;
}
