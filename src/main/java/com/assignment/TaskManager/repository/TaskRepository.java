package com.assignment.TaskManager.repository;

import com.assignment.TaskManager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.*;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
