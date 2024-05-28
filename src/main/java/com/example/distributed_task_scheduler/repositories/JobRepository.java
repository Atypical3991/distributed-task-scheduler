package com.example.distributed_task_scheduler.repositories;

import com.example.distributed_task_scheduler.models.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
    Job findByJobId(String jobId);
}
