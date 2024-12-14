package com.spring_boot_annotations.Service;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class LifecycleService {

    @PostConstruct  // Executes after the bean is created.
    public void init() {
        System.out.println("Bean has been initialized.");
    }

    @PreDestroy  // Executes before the bean is destroyed.
    public void destroy() {
        System.out.println("Bean is about to be destroyed.");
    }
}
