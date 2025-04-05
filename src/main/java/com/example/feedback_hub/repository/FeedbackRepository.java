package com.example.feedback_hub.repository;

import com.example.feedback_hub.model.Feedback;
import com.example.feedback_hub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByUser(User user);
}
