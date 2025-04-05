package com.example.feedback_hub.controller;
import com.example.feedback_hub.model.Feedback;
import com.example.feedback_hub.repository.UserRepository;
import com.example.feedback_hub.service.FeedbackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.feedback_hub.model.User;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
@RequiredArgsConstructor
public class FeedBackController {
    private final FeedbackService feedbackService;
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> createFeedback(
            @Valid @RequestBody Feedback feedback,
            @RequestParam Long userId
    ) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        Feedback savedFeedback = feedbackService.createFeedback(feedback, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFeedback);
    }

    @GetMapping("/user/{userId}")
    public List<Feedback> getFeedbacksByUser(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return feedbackService.getFeedbacksByUser(user);
    }
}