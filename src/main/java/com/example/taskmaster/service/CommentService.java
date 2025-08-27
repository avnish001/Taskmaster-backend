package com.example.taskmaster.service;

import com.example.taskmaster.entity.Comment;
import com.example.taskmaster.entity.Task;
import com.example.taskmaster.entity.User;
import com.example.taskmaster.exception.ResourceNotFoundException;
import com.example.taskmaster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    public List<Comment> getCommentsByTask(Long taskId) {
        Task task = taskService.getTaskById(taskId);
        return commentRepository.findByTaskId(taskId);
    }

    public Comment addCommentToTask(Long taskId, Comment comment) {
        Task task = taskService.getTaskById(taskId);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.getUserByUsername(username);

        comment.setTask(task);
        comment.setUser(user);
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long commentId, Comment commentDetails) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        comment.setContent(commentDetails.getContent());
        return commentRepository.save(comment);
    }

    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        commentRepository.delete(comment);
    }
}