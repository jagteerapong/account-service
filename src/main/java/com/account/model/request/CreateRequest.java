package com.account.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateRequest {
	@NotBlank
	@Size(min = 5, max = 5)
	@Schema(description = "Account number", example = "99999")
	private String accountNumber;
	
	@NotBlank
	@Schema(description = "Firstname of account", example = "Luka")
	private String firstname;
	
	@NotBlank
	@Schema(description = "Lastname of account", example = "Modric")
	private String lastname;
	
	@NotBlank
	@Schema(description = "Mobile phone of account", example = "0890001122")
	private String mobilePhone;
	
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
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
