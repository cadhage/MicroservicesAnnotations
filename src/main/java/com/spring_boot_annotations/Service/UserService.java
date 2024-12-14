package com.spring_boot_annotations.Service;

import com.spring_boot_annotations.Model.User;
import com.spring_boot_annotations.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  // Marks this class as a service.
public abstract class UserService {

    @Autowired  // Injects the UserRepository automatically.
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Cacheable("users")  // Caches the result of this method with the "users" cache name.
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public abstract String getUserType();
}
