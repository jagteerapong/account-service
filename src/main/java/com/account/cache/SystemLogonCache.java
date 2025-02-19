package com.account.cache;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.account.constants.AppConstant;
import com.account.entity.SystemLogon;
import com.account.repository.SystemLogonRepository;

@Component
public class SystemLogonCache {
	private static final Logger log = LogManager.getLogger(SystemLogonCache.class);
	
	private final SystemLogonRepository systemLogonRepository;
	
	public SystemLogonCache(SystemLogonRepository systemLogonRepository) {
		this.systemLogonRepository = systemLogonRepository;
	}
	
	@Cacheable("system-logon")
	public SystemLogon getSystemLogon(String systemName) {
		SystemLogon systemLogon = null;
		try {
			log.info("getSystemLogon : systemName = {}", systemName);
			Optional<SystemLogon> optSystemLogon = systemLogonRepository.findBySystemNameAndActiveStatus(systemName, AppConstant.SystemLogon.ACTIVE_STATUS_Y);
			if(optSystemLogon.isPresent()) {
				systemLogon = optSystemLogon.get();
			}
		} catch (Exception e) {
			log.error("Error getSystemLogon", e);
		}
		return systemLogon;
	}
}
