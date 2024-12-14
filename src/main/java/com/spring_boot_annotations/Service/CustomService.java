package com.spring_boot_annotations.Service;


import com.spring_boot_annotations.OtherImpExample.CustomAnnotation;
import org.springframework.stereotype.Service;

@Service
public class CustomService {

    @CustomAnnotation(description = "Custom annotation on method")
    public void customMethod() {
        System.out.println("Custom method with custom annotation");
    }
}
