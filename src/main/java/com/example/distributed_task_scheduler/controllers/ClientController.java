package com.example.distributed_task_scheduler.controllers;

import com.example.distributed_task_scheduler.DTOs.job.JobDetail;
import com.example.distributed_task_scheduler.DTOs.task.AddTwoNumbersArgs;
import com.example.distributed_task_scheduler.services.ClientService;
import com.example.distributed_task_scheduler.tasks.TaskEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/v1/client")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/create-add-numbers-task")
    public ResponseEntity<String> createSumTask(@RequestParam(name = "taskName") String taskName, @RequestBody AddTwoNumbersArgs taskArgs) {
        ;
        try {
            TaskEnum taskEnum = TaskEnum.valueOf(taskName);
            JobDetail jobDetail = new JobDetail();
            jobDetail.setTaskEnum(taskEnum);
            jobDetail.setTaskArgs(taskArgs);
            return ResponseEntity.ok().body(clientService.registerJob(jobDetail));
        } catch (Exception e) {
            log.error(String.format("createSumTask call failed!! taskName: %s, taskArgs: %s.", taskName, taskArgs.toString()));
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }
}
