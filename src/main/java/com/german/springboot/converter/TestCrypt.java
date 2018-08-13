package com.german.springboot.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestCrypt {

	public static void main(String[] args) {
		BCryptPasswordEncoder b = new BCryptPasswordEncoder();
		System.out.println(b.encode("usuario"));

	}

}
