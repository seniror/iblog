package com.seniror;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.seniror.iblog.dao.PostRepository;
import com.seniror.iblog.dao.UserRepository;
import com.seniror.iblog.domain.Post;
import com.seniror.iblog.domain.User;
import com.seniror.iblog.domain.User.UserRole;

//@Configuration
//@Profile("dev")
public class DataConfigDev {

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Bean
	public CommandLineRunner demo(PostRepository postRepository, UserRepository userRepository) {
		return (args) -> {
			User admin = new User();
			admin.setRole(UserRole.ROLE_ADMIN);
			admin.setLoginName("admin");
			admin.setPassword(passwordEncoder.encode("hello"));
			userRepository.save(admin);
			Calendar oneYearBefore = Calendar.getInstance();
			oneYearBefore.set(Calendar.YEAR, oneYearBefore.get(Calendar.YEAR) - 1);
			
			Calendar twoYearBefore = Calendar.getInstance();
			twoYearBefore.set(Calendar.YEAR, twoYearBefore.get(Calendar.YEAR) - 2);
			
			Calendar today = Calendar.getInstance();
			
			postRepository.save(new Post()
									.title("title 1")
									.sourceContent("content 1")
									.htmlContent("content")
									.creator(admin)
									.permLink("title1")
									.createdTime(twoYearBefore.getTime())
									);
			
			twoYearBefore.set(Calendar.DAY_OF_YEAR, twoYearBefore.get(Calendar.DAY_OF_YEAR) - 7);
			postRepository.save(new Post()
					.title("title 2")
					.sourceContent("content 2")
					.htmlContent("content")
					.creator(admin)
					.permLink("title2")
					.createdTime(twoYearBefore.getTime())
					);			
			
			postRepository.save(new Post()
					.title("title 3")
					.sourceContent("content 3")
					.htmlContent("content")
					.creator(admin)
					.permLink("title3")
					.createdTime(oneYearBefore.getTime())
					);
			
			oneYearBefore.set(Calendar.DAY_OF_YEAR, oneYearBefore.get(Calendar.DAY_OF_YEAR) - 7);
			postRepository.save(new Post()
					.title("title 4")
					.sourceContent("content 4")
					.htmlContent("content")
					.creator(admin)
					.permLink("title4")
					.createdTime(oneYearBefore.getTime())
					);			
			
			postRepository.save(new Post()
					.title("title 5")
					.sourceContent("content 5")
					.htmlContent("content")
					.creator(admin)
					.permLink("title5")
					.createdTime(today.getTime())
					);
			
			today.set(Calendar.DAY_OF_YEAR, today.get(Calendar.DAY_OF_YEAR) - 100);
			postRepository.save(new Post()
					.title("title 6")
					.sourceContent("content 6")
					.htmlContent("content")
					.creator(admin)
					.permLink("title6")
					.createdTime(today.getTime())
					);
			
			today.set(Calendar.DAY_OF_YEAR, today.get(Calendar.DAY_OF_YEAR) - 50);
			postRepository.save(new Post()
					.title("title 7")
					.sourceContent("content 7")
					.htmlContent("content")
					.creator(admin)
					.permLink("title7")
					.createdTime(today.getTime())
					);
			
		};
	}
}
