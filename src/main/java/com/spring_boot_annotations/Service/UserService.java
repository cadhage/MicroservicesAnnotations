package com.spring_boot_annotations.Service;

import com.spring_boot_annotations.Model.Post;
import com.spring_boot_annotations.Model.Profile;
import com.spring_boot_annotations.Model.Role;
import com.spring_boot_annotations.Model.User;
import com.spring_boot_annotations.Repository.RoleRepository;
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


    @Autowired
    private RoleRepository roleRepository;

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


//    public User createUser(User user) {
//        return userRepository.save(user);
//    }

    public User addProfile(Long userId, Profile profile) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setProfile(profile);
        return userRepository.save(user);
    }

    public User addPost(Long userId, Post post) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        post.setUser(user);
        user.getPosts().add(post);
        return userRepository.save(user);
    }

    public User addRole(Long userId, Role role) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Role savedRole = roleRepository.findByName(role.getName()).orElse(roleRepository.save(role));
        user.getRoles().add(savedRole);
        return userRepository.save(user);
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
