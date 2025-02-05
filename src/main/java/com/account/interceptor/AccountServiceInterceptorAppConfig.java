package com.account.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class AccountServiceInterceptorAppConfig implements WebMvcConfigurer {
	
	@Autowired
	AccountServiceInterceptor accountServiceInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(accountServiceInterceptor);
	}
}
