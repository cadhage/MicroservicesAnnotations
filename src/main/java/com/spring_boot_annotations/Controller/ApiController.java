package com.spring_boot_annotations.Controller;

import com.spring_boot_annotations.Model.User;
import com.spring_boot_annotations.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
@RestController
@RequestMapping("/api")  // Base URL for all controller mappings.
public class ApiController {

   @Autowired
    private UserRepository userRepository;
//
//    public ApiController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @RequestMapping("/greet")  // Maps to GET /api/greet
    public String greet() {
        return "Hello, welcome to the Spring Boot application!";
    }

    @GetMapping("/hello")  // Maps to GET /api/hello
    public String hello() {
        return "Hello from @GetMapping";
    }

    @PostMapping("/post")  // Maps to POST /api/post
    public String post(@RequestBody String body) {
        return "Received: " + body;
    }

    @PostMapping("/add/all/users")
    public ResponseEntity<List<User>> addingMultipleUsers(@RequestBody List<User> users) {
        List<User> saveAll=userRepository.saveAll(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveAll);
    }
//    @PostMapping("/add/all/users")
//    public ResponseEntity<List<User>> addingMultipleUsers(@RequestBody List<User> users) {
//        List<User> savedUsers = userRepository.saveAll(users);  // Assuming saveAll is supported by your repository
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedUsers);
//    }
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(@RequestParam String name) {
        List<User> users = userRepository.findByName(name);
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return ResponseEntity.ok(user);
    }

}

