package com.spring_boot_annotations.Repository;

import com.spring_boot_annotations.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
