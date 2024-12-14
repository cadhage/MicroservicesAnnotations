package com.spring_boot_annotations.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // Marks this class as a configuration class for beans.
public class AppConfig {

    @Bean  // Declares that this method creates a Spring bean.
    public String exampleBean() {
        return "This is a Spring Bean!";
    }
}
