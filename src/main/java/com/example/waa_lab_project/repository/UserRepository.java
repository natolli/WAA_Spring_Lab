package com.example.waa_lab_project.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.waa_lab_project.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE SIZE(u.posts) > 1")
    List<User> findUsersWithMoreThanOnePost();
}