package com.spring_boot_annotations.Service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;

@Service
@Primary // Mark as the default service to be injected when there's ambiguity
public class BasicUserService extends UserService {

    @Override
    public String getUserType() {
        return "Basic User";
    }
}
