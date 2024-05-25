package com.example.spring_kubernetes_setup.tasks;

import com.example.spring_kubernetes_setup.DTOs.task.TaskArgs;

public interface Task {
    void execute(TaskArgs taskArgs);
}
