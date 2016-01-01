package com.seniror;

import java.util.Calendar;

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
			Calendar oneYearBefore = Calendar.getInstance();
			oneYearBefore.set(Calendar.YEAR, oneYearBefore.get(Calendar.YEAR) - 1);
			
			Calendar twoYearBefore = Calendar.getInstance();
			twoYearBefore.set(Calendar.YEAR, twoYearBefore.get(Calendar.YEAR) - 2);
			
			postRepository.save(new Post("title 1", "content 1", admin, twoYearBefore.getTime()));
			postRepository.save(new Post("title 2", "content 2", admin, twoYearBefore.getTime()));
			postRepository.save(new Post("title 3", "content 3", admin, oneYearBefore.getTime()));
			postRepository.save(new Post("title 4", "content 4", admin, oneYearBefore.getTime()));
			postRepository.save(new Post("title 5", "content 5", "content 5", admin));
			postRepository.save(new Post("title 6", "content 6", "content 6", admin));
			postRepository.save(new Post("title 7", "content 7", "content 7", admin));
		};
	}

}
