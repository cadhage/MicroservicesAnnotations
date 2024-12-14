package com.spring_boot_annotations.Repository;


import com.spring_boot_annotations.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // Marks this interface as a Spring Data repository for CRUD operations.
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
    @Query("SELECT u FROM User u WHERE u.name = :name AND u.email = :email")
    List<User> findByNameAndId(@Param("name") String name, @Param("email") Long email);


}
