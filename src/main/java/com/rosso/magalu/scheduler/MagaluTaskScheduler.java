package com.rosso.magalu.scheduler;

import com.rosso.magalu.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class MagaluTaskScheduler {

    private static final Logger logger = LoggerFactory.getLogger(MagaluTaskScheduler.class);

    @Autowired
    private NotificationService notificationService;

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void checkTasks() {
        var currentDateTime = LocalDateTime.now();
        logger.info("executando em {}", currentDateTime);
        notificationService.checkAndSend(currentDateTime);
    }
}
