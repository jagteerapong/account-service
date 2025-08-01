package com.account.security;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "auth")
public class AuthUserProperties {
	
	private List<UserAuthen> users;

	public List<UserAuthen> getUsers() {
		return users;
	}

	public void setUsers(List<UserAuthen> users) {
		this.users = users;
	}
}
