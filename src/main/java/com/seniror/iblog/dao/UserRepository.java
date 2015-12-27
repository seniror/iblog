package com.seniror.iblog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seniror.iblog.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public User findUserByLoginNameAndPassword(String loginName, String password);
	
	public User findUserByLoginName(String loginName);
}
