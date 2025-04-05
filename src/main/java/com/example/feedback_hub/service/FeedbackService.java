package com.example.feedback_hub.service;

import com.example.feedback_hub.model.Feedback;
import com.example.feedback_hub.model.User;
import com.example.feedback_hub.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final FeedbackRepository feedbackRepo;

    public Feedback createFeedback(Feedback feedback, User user) {
        if (feedback.getRating() < 1 || feedback.getRating() > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        feedback.setUser(user);
        feedback.setCreatedAt(LocalDateTime.now());
        return feedbackRepo.save(feedback);
    }

    public List<Feedback> getFeedbacksByUser(User user) {
        return feedbackRepo.findByUser(user);
    }
} 