package com.german.springboot.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.german.springboot.entity.UserRole;
import com.german.springboot.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.german.springboot.entity.User user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
		return buildUser(user, authorities);
	}

	public User buildUser(com.german.springboot.entity.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.getEnables(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles) {
		Set<GrantedAuthority> auth = new HashSet<>();
		for (UserRole userRole : userRoles) {
			auth.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return new ArrayList<>(auth);
	}

}
