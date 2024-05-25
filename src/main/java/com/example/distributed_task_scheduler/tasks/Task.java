package com.example.distributed_task_scheduler.tasks;

import com.example.distributed_task_scheduler.DTOs.task.TaskArgs;

public interface Task {
    void execute(TaskArgs taskArgs);
}
