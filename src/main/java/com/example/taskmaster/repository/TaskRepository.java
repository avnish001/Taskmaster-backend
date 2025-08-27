package com.example.taskmaster.repository;

import com.example.taskmaster.entity.Task;
import com.example.taskmaster.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAssignedToId(Long userId);
    List<Task> findByTeamId(Long teamId);
    List<Task> findByStatus(TaskStatus status);
    List<Task> findByTitleContainingOrDescriptionContaining(String title, String description);
}