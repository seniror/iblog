package com.seniror.iblog.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.seniror.iblog.dao.UserRepository;
import com.seniror.iblog.domain.User;

public class UserService implements UserDetailsService  {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        User user = userRepository.findUserByLoginName(username);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        
		return createSpringUser(user);
	}

    private org.springframework.security.core.userdetails.User createSpringUser(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getLoginName(),
                user.getPassword(),
                Collections.singleton(createAuthority(user)));
    }
	
    private GrantedAuthority createAuthority(User user) {
        return new SimpleGrantedAuthority(user.getRole().toString());
    }
    
    public User createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
