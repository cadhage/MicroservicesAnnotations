package com.spring_boot_annotations.OtherImpExample;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyExample {

    @Value("${app.name}")  // Injects the value from application.properties.
    private String appName;

    @Value("${app.description}")  // Injects the description property.
    private String appDescription;

    public void printAppInfo() {
        System.out.println("App Name: " + appName);
        System.out.println("App Description: " + appDescription);
    }
}
