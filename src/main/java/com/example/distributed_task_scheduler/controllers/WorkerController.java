package com.example.distributed_task_scheduler.controllers;

import com.example.distributed_task_scheduler.services.WorkerService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// https://medium.com/@nadinCodeHat/rest-api-naming-conventions-and-best-practices-1c4e781eb6a5
// Use nouns to represent resources and HTTP methods are then used to perform actions on those
// resources
@Slf4j
@RequestMapping("/v1/workers")
@RestController
public class WorkerController {

    @Autowired
    private WorkerService worker;

    @DeleteMapping("/{id}")
    public ResponseEntity<String> stopWorker(@PathParam("id") String id) {
        try {
            worker.stop();
            return ResponseEntity.ok().body("Worker stopped successfully.");
        } catch (Exception e) {
            log.error("stopWorker call failed!!", e);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }


    @GetMapping("/leader")
    public ResponseEntity<String> getLeaderId() {
        try {
            return ResponseEntity.ok().body(worker.getLeader().orElse("No leader found"));
        } catch (Exception e) {
            log.error("getLeaderId call failed!!", e);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
