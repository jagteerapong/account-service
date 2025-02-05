package com.account.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class UpdateEmailRequest {
	@NotBlank
	@Schema(description = "Account number", example = "99999")
	private String accountNumber;
	
	@NotBlank
	@Schema(description = "Email of account", example = "account@gmail.com")
	private String email;
	
	@NotBlank
	@Schema(description = "System name", example = "SYSTEM1")
	private String systemName;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
}
