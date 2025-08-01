package com.account.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
	
	private static final String ADMIN = "ADMIN";
	private static final String USER = "USER";
	private final AuthUserProperties authUserProperties;
	
	public SecurityConfig(AuthUserProperties authUserProperties) {
		this.authUserProperties = authUserProperties;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(AbstractHttpConfigurer::disable)
	        .authorizeHttpRequests(auth -> auth
	        	.requestMatchers("/account/create").hasAnyRole(ADMIN)
	        	.requestMatchers("/cache/clear-cache").hasAnyRole(ADMIN)
	        	.requestMatchers("/account/**").hasAnyRole(USER, ADMIN)
	        	.anyRequest().authenticated()
	        )
	        .httpBasic(withDefaults());

	    return http.build();
	}
	
	@Bean
	public UserDetailsService users(PasswordEncoder encoder) {
		List<UserDetails> userList = authUserProperties.getUsers()
				.stream()
				.map(u -> User.withUsername(u.getUsername())
						.password(encoder.encode(u.getPassword()))
						.roles(u.getRoles().toArray(new String[0]))
						.build()).toList();
		return new InMemoryUserDetailsManager(userList);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}
