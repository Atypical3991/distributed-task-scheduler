package com.example.distributed_task_scheduler.DTOs.task;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddTwoNumbersArgs implements TaskArgs, Serializable {
    @JsonProperty("a")
    private int a;
    @JsonProperty("b")
    private int b;
}
