package com.seniror;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class PasswordGeneratorTest {

	public static void main(String[] args) {
		StandardPasswordEncoder encoder = new StandardPasswordEncoder();
		System.out.println(encoder.encode(args[0]));
	}

}
