package com.example.feedback_hub;

import com.example.feedback_hub.model.User;
import com.example.feedback_hub.service.UserService;
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
	CommandLineRunner run(UserService userService) {
		return args -> {
			if (userService.getUserByUsername("admin").isEmpty()) {
				User admin = new User("admin", "password123", "ADMIN");
				userService.createUser(admin);
				System.out.println("✅ Admin user created");
			}
		};
	}
}



