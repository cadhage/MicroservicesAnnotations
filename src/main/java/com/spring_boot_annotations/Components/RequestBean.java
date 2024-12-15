package com.spring_boot_annotations.Components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("request")
public class RequestBean {
    private final String instanceId;

    public RequestBean() {
        this.instanceId = "Request-" + UUID.randomUUID();
    }

    public String getInstanceId() {
        return instanceId;
    }
}
