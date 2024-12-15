package com.spring_boot_annotations.Components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("prototype")
public class PrototypeBean {
    private final String instanceId;

    public PrototypeBean() {
        this.instanceId = "Prototype-" + UUID.randomUUID();
    }

    public String getInstanceId() {
        return instanceId;
    }
}
