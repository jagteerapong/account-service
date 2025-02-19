package com.account.service.impl;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import com.account.cache.SystemLogonCache;
import com.account.entity.SystemLogon;
import com.account.exception.SystemLogonNotValidException;
import com.account.service.AuthenSystemLogonService;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class AuthenSystemLogonServiceImpl implements AuthenSystemLogonService {
	
	private final SystemLogonCache systemLogonCache;
	
	public AuthenSystemLogonServiceImpl(SystemLogonCache systemLogonCache) {
		this.systemLogonCache = systemLogonCache;
	}

	@Override
	public void isSystemLogonActive(String systemName) throws Exception {
		try {
			SystemLogon systemLogon = systemLogonCache.getSystemLogon(systemName);
			if(ObjectUtils.isEmpty(systemLogon)) {
				throw new SystemLogonNotValidException();
			}
		} catch (Exception e) {
			throw e;
		}
	}

}
