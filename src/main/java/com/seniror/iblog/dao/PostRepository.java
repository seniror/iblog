package com.seniror.iblog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seniror.iblog.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

	public Post findPostByPermLink(String permLink);
}
