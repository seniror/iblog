package com.seniror.iblog.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seniror.iblog.dao.PostRepository;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostRepository postRepository;
	
	@RequestMapping("/findPostById")
	public String findPostById(Integer id, Map<String, Object> model) {
		model.put("post", postRepository.findOne(id));
		return "showPost";
	}

	@RequestMapping(path="/{permLink}")
	public String findPostByPermLink(@PathVariable String permLink, Map<String, Object> model) {
		model.put("post", postRepository.findPostByPermLink(permLink));
		return "showPost";
	}
}
