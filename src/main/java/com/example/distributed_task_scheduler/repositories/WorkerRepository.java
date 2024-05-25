package com.example.distributed_task_scheduler.repositories;

import com.example.distributed_task_scheduler.models.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
