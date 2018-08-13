package com.german.springboot.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "username", unique = true, nullable = false, length = 45)
	private String username;

	@Column(name = "password", nullable = false, length = 60)
	private String password;

	@Column(name = "enabled")
	private Boolean enabled;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<UserRole>();

	public User() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnables() {
		return enabled;
	}

	public void setEnables(Boolean enables) {
		this.enabled = enables;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	public User(String username, String password, Boolean enables, Set<UserRole> userRole) {
		this.username = username;
		this.password = password;
		this.enabled = enables;
		this.userRole = userRole;
	}

	public User(String username, String password, Boolean enables) {
		this.username = username;
		this.password = password;
		this.enabled = enables;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", enables=" + enabled + "]";
	}

}
