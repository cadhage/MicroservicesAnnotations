package com.spring_boot_annotations.Components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("singleton")
public class SingletonBean {
    private final String instanceId;

    public SingletonBean() {
        this.instanceId = "Singleton-" + UUID.randomUUID();
    }

    public String getInstanceId() {
        return instanceId;
    }
}

