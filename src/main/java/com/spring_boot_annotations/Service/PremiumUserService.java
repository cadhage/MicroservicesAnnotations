package com.spring_boot_annotations.Service;

import org.springframework.stereotype.Service;

@Service
public class PremiumUserService extends UserService {

    @Override
    public String getUserType() {
        return "Premium User";
    }
}
