package com.spring_boot_annotations.Controller;


import com.spring_boot_annotations.Model.Post;
import com.spring_boot_annotations.Model.Profile;
import com.spring_boot_annotations.Model.Role;
import com.spring_boot_annotations.Model.User;
import com.spring_boot_annotations.Repository.UserRepository;
import com.spring_boot_annotations.Service.UserService;
import jakarta.persistence.Cacheable;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController  // Marks this class as a REST controller.
@RequestMapping("/api/users")  // Maps the base URL for user-related API endpoints.
public class UserController {

    @Autowired  // Injects the UserService automatically.
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping  // Handles GET requests to fetch all users.
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

//    @PostMapping  // Handles POST requests to create a new user.
//    public User createUser(@RequestBody @Valid User user) {  // Binds the request body to a User object.
//        return userService.createUser(user);
//    }

//    @PostMapping("/users")
//    public ResponseEntity<User> createByUser(@RequestBody User user) {
//        userService.createUser(user);
//        return ResponseEntity.status(HttpStatus.CREATED).body(user);
//    }

//    @GetMapping("/{id}")  // Handles GET requests to fetch a user by ID.
//    public User getUser(@PathVariable Long id) {  // Binds the ID from the URL to the method parameter.
//        return userService.getUserById(id);
//    }
    @GetMapping("/by/{id}")  // Handles GET requests to fetch a user by ID.
    public User getUserByUser(@PathVariable Long id) {  // Binds the ID from the URL to the method parameter.
        return userService.getUserById(id);
    }

    // PATCH request to update only the email of the user
    @PatchMapping("/patch/{id}")
    public ResponseEntity<User> updateEmail(@PathVariable Long id, @RequestBody String email) throws Exception {
        // Find the user by ID
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new Exception("User not found with id: " + id);
        }

        User user = userOptional.get();

        // Update the email if provided
        user.setEmail(email);

        // Save the updated user
        userRepository.save(user);

        return ResponseEntity.ok(user);
    }
    private final UserService basicUserService;  // Will use the @Primary service by default
    private final UserService premiumUserService;  // Will use the @Qualifier service

    // Constructor injection
    public UserController(UserService basicUserService,
                          @Qualifier("premiumUserService") UserService premiumUserService) {
        this.basicUserService = basicUserService;
        this.premiumUserService = premiumUserService;
    }

    @GetMapping("/basic-user")
    public String getBasicUserInfo() {
        return basicUserService.getUserType(); // This will return "Basic User"
    }

    @GetMapping("/premium-user")
    public String getPremiumUserInfo() {
        return premiumUserService.getUserType(); // This will return "Premium User"
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("/{userId}/profile")
    public ResponseEntity<User> addProfile(@PathVariable Long userId, @RequestBody Profile profile) {
        return ResponseEntity.ok(userService.addProfile(userId, profile));
    }

    @PostMapping("/{userId}/posts")
    public ResponseEntity<User> addPost(@PathVariable Long userId, @RequestBody Post post) {
        return ResponseEntity.ok(userService.addPost(userId, post));
    }

    @PostMapping("/{userId}/roles")
    public ResponseEntity<User> addRole(@PathVariable Long userId, @RequestBody Role role) {
        return ResponseEntity.ok(userService.addRole(userId, role));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }
}
