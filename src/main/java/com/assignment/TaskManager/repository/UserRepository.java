package com.assignment.TaskManager.repository;

import com.assignment.TaskManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
