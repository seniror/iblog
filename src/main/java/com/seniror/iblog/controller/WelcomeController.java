package com.seniror.iblog.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seniror.comparator.PostYearDescComparator;
import com.seniror.iblog.dao.PostRepository;
import com.seniror.iblog.domain.Post;

@Controller
public class WelcomeController {

	private static final int DEFAULT_PAGE_INDEX = 0;
	private static final int PAGE_SIZE = 5;
	@Autowired
	private PostRepository postRepository;
	
	private static java.util.concurrent.atomic.AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		
		System.out.println(counter.getAndIncrement());
		
		PageRequest pageRequest = new PageRequest(DEFAULT_PAGE_INDEX, PAGE_SIZE, Sort.Direction.DESC, "createdTime");
		Page<Post> posts = postRepository.findByPublishedTrue(pageRequest);
		model.put("posts", posts.getContent());
		return "welcome";
	}
	
	@RequestMapping("/archives")
	public String archives(Map<String, Object> model) {
		List<Post> posts = postRepository.findByPublishedTrue();
		// sort inner collection
		Map<Integer, List<Post>> groupByYearPosts = 
				posts.stream().sorted().collect(Collectors.groupingBy(Post::getCreatedYear));
		// sort key
		Map<Integer, List<Post>> sortedByKey = new TreeMap<>(new PostYearDescComparator());
		sortedByKey.putAll(groupByYearPosts);
		
		model.put("postsGroupByKey", sortedByKey);
		return "archives";
	}	
	
	@RequestMapping(value="/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}

}