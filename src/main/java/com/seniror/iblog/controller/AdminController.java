package com.seniror.iblog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seniror.iblog.dao.PostRepository;
import com.seniror.iblog.dao.UserRepository;
import com.seniror.iblog.domain.Post;
import com.seniror.iblog.domain.User;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/index")
	public String index(Map<String, Object> model) {
		List<Post> posts = postRepository.findAll();
		model.put("posts", posts);
	    return "admin/index";
	}	
	
	@RequestMapping("/newPost")
	public String newPost(String title, String content, Map<String, Object> model) {
	    return "admin/newPost";
	}
	
	@RequestMapping("/createPost")
	public String createPost(String title, String content, Map<String, Object> model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	    User user = userRepository.findUserByLoginName(name);
	    Post post = postRepository.save(new Post(title, content, user));
	    model.put("post", post);
	    return "redirect:/admin/index";
	}
	
	@RequestMapping("/loadPost")
	public String findPostById(Integer id, Map<String, Object> model) {
		model.put("post", postRepository.findOne(id));
		return "admin/loadPost";
	}	
	
	@RequestMapping("/updatePost")
	public String updatePost(String title, String content, Integer postId, Map<String, Object> model) {
		
	    Post post = postRepository.findOne(postId);
	    post.setContent(content);
	    post.setTitle(title);
	    postRepository.save(post);
	    model.put("post", post);
	    return "redirect:/admin/index";
	}	
}
