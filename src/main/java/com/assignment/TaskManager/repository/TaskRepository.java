package com.assignment.TaskManager.repository;

import com.assignment.TaskManager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.*;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Page<Task> findByStatus(String status, Pageable pageable);

    Page<Task> findByAssignedToId(Long userId, Pageable pageable);

    Page<Task> findByStatusAndAssignedToId(String status, Long userId, Pageable pageable);

}
