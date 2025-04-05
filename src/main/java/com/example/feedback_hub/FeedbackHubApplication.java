package com.example.feedback_hub;

import com.example.feedback_hub.model.User;
import com.example.feedback_hub.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FeedbackHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedbackHubApplication.class, args);
	}
	@Bean
	CommandLineRunner run(UserRepository userRepository) {
		return args -> {
			if (userRepository.findByUsername("admin").isEmpty()) {
				User admin = new User(null, "admin", "password123", "ADMIN");
				userRepository.save(admin);
				System.out.println("✅ Admin user created");
			}
		};
	}
}



