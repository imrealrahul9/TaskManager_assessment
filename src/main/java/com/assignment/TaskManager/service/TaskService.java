package com.assignment.TaskManager.service;

import com.assignment.TaskManager.entity.*;
import com.assignment.TaskManager.exception.*;
import com.assignment.TaskManager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public Task createTask(Task task) {
        // Validate that the assigned user exists :))
        User assignedUser = userRepository.findById(task.getAssignedTo().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(task.getDescription().isEmpty()){
            throw new ValidationException("Description cannot be empty");
        }
        if(task.getTitle().isEmpty()){
            throw new ValidationException("Title cannot be empty");
        }
        if(!assignedUser.isActive()){
            throw new ValidationException("Assigned to is not active");
        }

        task.setAssignedTo(assignedUser);
        return taskRepository.save(task);
    }


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task updateTask(Long id, Task task) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setStatus(task.getStatus());
        User assignedUser = userRepository.findById(task.getAssignedTo().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingTask.setAssignedTo(assignedUser);
        return taskRepository.save(existingTask);
    }
    public void deleteTask(Long id) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        taskRepository.delete(existingTask);
    }

}