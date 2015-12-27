package com.seniror.iblog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seniror.iblog.dao.PostRepository;
import com.seniror.iblog.domain.Post;

@Controller
public class WelcomeController {

	@Autowired
	private PostRepository postRepository;
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		List<Post> posts = postRepository.findAll();
		model.put("posts", posts);
		return "welcome";
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