package com.account.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SYSTEM_LOGON")
public class SystemLogon {
	@Id
	@Column(name = "SYSTEM_NAME", nullable = false)
	private String systemName;
	
	@Column(name = "ACTIVE_STATUS", nullable = false)
	private String activeStatus;

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
}
