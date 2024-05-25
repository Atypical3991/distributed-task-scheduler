package com.example.spring_kubernetes_setup.controllers;

import com.example.spring_kubernetes_setup.services.WorkerService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

//    private final CuratorFrameworkComponent curatorFrameworkComponent;

    @Autowired
    private WorkerService worker;

//    @Autowired
//    public WorkerController(CuratorFrameworkComponent curatorFrameworkComponent) {
//        this.curatorFrameworkComponent = curatorFrameworkComponent;
//        initWorker();
//    }
//
//    public void initWorker() {
//        worker = new WorkerService(curatorFrameworkComponent.getCuratorFramework(), ZKUtils.LEADER_ROOT);
//    }

    @DeleteMapping("/{id}")
    public void stopWorker(@PathParam("id") String id) {
        worker.stop();
    }


    @GetMapping("/leader")
    public String getLeaderId() {
        return worker.getLeader().orElse("No leader found");
    }
}
