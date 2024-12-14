package com.spring_boot_annotations.Model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


//@Entity  // This class is a JPA entity mapped to a database table.
//@Data  // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods.
//@Table(name = "app_user")  // Change to a non-reserved table name
//public class User {
//
//    @Id  // Marks this field as the primary key.
//    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generates the ID.
//    private Long id;
//
//    private String name;
//    private String email;
//}

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void setProfile(Profile profile) {
    }

    public <E> List<E> getRoles() {
        return null;
    }
}
