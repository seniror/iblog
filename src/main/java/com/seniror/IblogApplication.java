package com.seniror;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.seniror.iblog.dao.PostRepository;
import com.seniror.iblog.dao.UserRepository;
import com.seniror.iblog.domain.Post;
import com.seniror.iblog.domain.User;
import com.seniror.iblog.domain.User.UserRole;

@SpringBootApplication
public class IblogApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(IblogApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PostRepository postRepository, UserRepository userRepository) {
		return (args) -> {
			User admin = new User();
			admin.setRole(UserRole.ROLE_ADMIN);
			admin.setLoginName("admin");
			userRepository.save(admin);
			postRepository.save(new Post("title 1", "content 1", admin));
			postRepository.save(new Post("title 2", "content 2", admin));
			postRepository.save(new Post("title 3", "content 3", admin));
		};
	}

}
