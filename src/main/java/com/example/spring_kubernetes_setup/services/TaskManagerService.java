package com.example.spring_kubernetes_setup.services;

import com.example.spring_kubernetes_setup.DTOs.job.JobDetail;
import com.example.spring_kubernetes_setup.tasks.AddTwoNumbersTask;
import com.example.spring_kubernetes_setup.tasks.Task;
import com.example.spring_kubernetes_setup.tasks.TaskEnum;
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