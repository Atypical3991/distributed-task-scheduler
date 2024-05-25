package com.example.spring_kubernetes_setup.DTOs.job;

import com.example.spring_kubernetes_setup.DTOs.task.TaskArgs;
import com.example.spring_kubernetes_setup.tasks.TaskEnum;
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
