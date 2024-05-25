package com.example.distributed_task_scheduler.services;

import com.example.distributed_task_scheduler.DTOs.job.JobDetail;
import com.example.distributed_task_scheduler.tasks.AddTwoNumbersTask;
import com.example.distributed_task_scheduler.tasks.Task;
import com.example.distributed_task_scheduler.tasks.TaskEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TaskManagerService {

    private final Map<TaskEnum, Task> taskMap = new HashMap<>();

    @Autowired
    public TaskManagerService(AddTwoNumbersTask addTwoNumbersTask) {
        taskMap.put(TaskEnum.ADD_TWO_NUMBERS, addTwoNumbersTask);
    }

    public void processTask(JobDetail jobDetail) {
        try {
            taskMap.get(jobDetail.getTaskEnum()).execute(jobDetail.getTaskArgs());
        } catch (Exception e) {

        }

    }
}