package com.spring_boot_annotations.Model;


import jakarta.persistence.*;
import lombok.Data;


@Entity  // This class is a JPA entity mapped to a database table.
@Data  // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods.
@Table(name = "app_user")  // Change to a non-reserved table name
public class User {

    @Id  // Marks this field as the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generates the ID.
    private Long id;

    private String name;
    private String email;
}
