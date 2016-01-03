package com.seniror.iblog.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seniror.iblog.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

	public Post findPostByPermLink(String permLink);
	
	public List<Post> findByPublishedTrue();
	
	public Page<Post> findByPublishedTrue(Pageable pageRequest);
}
