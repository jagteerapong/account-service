package com.account.service;

import com.account.model.request.CreateRequest;
import com.account.model.request.DeleteRequest;
import com.account.model.request.UpdateEmailRequest;
import com.account.model.request.UpdateMobileRequest;
import com.account.model.response.AccountBean;

public interface AccountService {
	public void createAccount(CreateRequest request) throws Exception;
	public void updateMobile(UpdateMobileRequest request) throws Exception;
	public void updateEmail(UpdateEmailRequest request) throws Exception;
	public void deleteAccount(DeleteRequest request) throws Exception;
	public AccountBean getAccountByAccountNumber(String accountNumber) throws Exception;
}
