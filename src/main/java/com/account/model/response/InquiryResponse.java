package com.account.model.response;


public class InquiryResponse extends ResponseMessage {
	private AccountBean account;

	public AccountBean getAccount() {
		return account;
	}

	public void setAccount(AccountBean account) {
		this.account = account;
	}
	
}
