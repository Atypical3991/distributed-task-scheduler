package com.example.distributed_task_scheduler.repositories;

import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<BatchProperties.Job, Long> {
}
