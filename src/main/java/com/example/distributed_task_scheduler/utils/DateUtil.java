package com.example.distributed_task_scheduler.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateUtil {

    public static LocalDateTime getCurrentISTTime() {
        return LocalDateTime.now().atZone(ZoneId.of("Asia/Kolkata")).toLocalDateTime();
    }
}
