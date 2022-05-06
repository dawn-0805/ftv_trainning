package com.ftvtraining.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks  {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);
/*    @Scheduled(fixedRate = 10000)
    public void scheduleTaskWithFixedRate() {
        LOGGER.info("Send email ");
    }
    @Scheduled(fixedDelay = 10000)
    public void scheduleTaskWithFixedDelay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("Send email to producers ");
    }

    @Scheduled(fixedRate = 2000, initialDelay = 10000)
    public void scheduleTaskWithInitialDelay() {
        LOGGER.info("Send email to producers to inform quantity ");
    }

    @Scheduled(cron = "15 * * * * ?")
    public void scheduleTaskWithCronExpression() {
        LOGGER.info("Send email to producers to inform quantity sold items");
    }*/
}
