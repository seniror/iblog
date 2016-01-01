package com.seniror.iblog.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seniror.iblog.dao.PostRepository;
import com.seniror.iblog.dao.UserRepository;
import com.seniror.iblog.domain.Post;
import com.seniror.iblog.domain.User;
import com.seniror.util.MarkdownService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MarkdownService markdownService;
	
	private static final int DEFAULT_PAGE_INDEX = 0;
	private static final int PAGE_SIZE = 5;
	
	@RequestMapping("/index")
	public String index(Integer pageIndex, Map<String, Object> model) {
		String name = getLoginUsername();
		model.put("loginUsername", name);
		
		if(pageIndex == null) {
			pageIndex = DEFAULT_PAGE_INDEX;
		}
		
		PageRequest pageRequest = new PageRequest(pageIndex, PAGE_SIZE, Sort.Direction.DESC, "createdTime");
		Page<Post> paginationPosts = postRepository.findAll(pageRequest);
		model.put("paginationPosts", paginationPosts);
	    return "admin/index";
	}	
	
	@RequestMapping("/newPost")
	public String newPost(String title, String content, Map<String, Object> model) {
	    return "admin/newPost";
	}
	
	@RequestMapping("/createPost")
	public String createPost(String title, String markdownSource, String permLink, Map<String, Object> model) {
		String name = getLoginUsername();
	    User user = userRepository.findUserByLoginName(name);
	    String parsedHtmlContent = markdownService.toHtml(markdownSource);
	    Post post = postRepository.save(
	    		new Post()
	    			.title(title)
	    			.markdownSource(markdownSource)
	    			.htmlContent(parsedHtmlContent)
	    			.creator(user)
	    			.permLink(permLink));
	    model.put("post", post);
	    return "redirect:/admin/index";
	}

	private String getLoginUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get login username
		return name;
	}
	
	@RequestMapping("/loadPost")
	public String findPostById(Integer id, Map<String, Object> model) {
		model.put("post", postRepository.findOne(id));
		return "admin/loadPost";
	}	
	
	@RequestMapping("/updatePost")
	public String updatePost(String title, String editorContent, String permLink, Integer postId, Map<String, Object> model) {
		
	    Post post = postRepository.findOne(postId);
	    post.markdownSource(editorContent)
	    	.title(title)
	    	.permLink(permLink);
	    postRepository.save(post);
	    model.put("post", post);
	    return "redirect:/admin/index";
	}	
	
	@RequestMapping("/deletePost")
	public String deletePost(Integer id) {
		
	    postRepository.delete(id);
	    return "redirect:/admin/index";
	}	
}
