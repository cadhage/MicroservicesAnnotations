package com.spring_boot_annotations.Components;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling  // Enables the scheduling of tasks in the Spring Boot application.
@Component  // Marks this class as a Spring-managed component.
public class ScheduledTasks {

    @Scheduled(fixedRate = 5000)  // Runs every 5 seconds after the last execution.
    public void scheduledTask() {
        System.out.println("Scheduled task is running...");
    }

    @EventListener(ApplicationReadyEvent.class)  // Executes after the application has started.
    public void onApplicationReady() {
        System.out.println("Application is ready!");
    }
}

