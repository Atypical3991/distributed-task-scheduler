package com.example.spring_kubernetes_setup.controllers;

import com.example.spring_kubernetes_setup.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@Slf4j
@RequestMapping("/v1/client")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/create-sub-task")
    public String createSumTask(@RequestParam(name = "paramA") int paramA, @RequestParam(name = "paramB") int paramB) {
        Runnable jobDetail =
                (Runnable & Serializable)
                        (() -> System.out.println("Sum of " + paramA + " and " + paramB + " is " + (paramA + paramB)));
        return clientService.registerJob(jobDetail);
    }
}
