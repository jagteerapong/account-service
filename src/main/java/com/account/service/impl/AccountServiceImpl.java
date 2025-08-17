package com.account.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.account.constants.AccountResponse;
import com.account.entity.Account;
import com.account.model.request.CreateRequest;
import com.account.model.request.DeleteRequest;
import com.account.model.request.UpdateEmailRequest;
import com.account.model.request.UpdateMobileRequest;
import com.account.model.response.AccountBean;
import com.account.repository.AccountRepository;
import com.account.service.AccountService;

import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	private AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@Override
	public void createAccount(CreateRequest request) throws Exception {
		if(accountRepository.existsById(request.getAccountNumber())) {
			throw new Exception(AccountResponse.Message.ACCOUNT_DUPLICATE);
		}
		
		Account account = getAccount(request);
		accountRepository.save(account);
	}
	
	@Override
	public void updateMobile(UpdateMobileRequest request) throws Exception {
		Optional<Account> account = accountRepository.findById(request.getAccountNumber());
		if(account.isEmpty()) {
			throw new NoResultException();
		}
		
		account.get().setMobilePhone(request.getMobilePhone());
		accountRepository.save(account.get());
	}
	
	@Override
	public void updateEmail(UpdateEmailRequest request) throws Exception {
		Optional<Account> account = accountRepository.findById(request.getAccountNumber());
		if(account.isEmpty()) {
			throw new NoResultException();
		}
		
		account.get().setEmail(request.getEmail());
		accountRepository.save(account.get());
	}
	
	@Override
	public void deleteAccount(DeleteRequest request) throws Exception {
		Optional<Account> account = accountRepository.findById(request.getAccountNumber());
		if(account.isEmpty()) {
			throw new NoResultException();
		}
		
		accountRepository.delete(account.get());
	}

	@Override
	public AccountBean getAccountByAccountNumber(String accountNumber) throws Exception {
		Optional<Account> account = accountRepository.findById(accountNumber);
		if(account.isEmpty()) {
			throw new NoResultException();
		}
		
		return getAccountBean(account.get());
	}
	
	private Account getAccount(CreateRequest request) {
		Account account = new Account();
		account.setAccountNumber(request.getAccountNumber());
		account.setFirstname(request.getFirstname());
		account.setLastname(request.getLastname());
		account.setEmail(request.getEmail());
		account.setMobilePhone(request.getMobilePhone());
		return account;
	}

	private AccountBean getAccountBean(Account account) {
		AccountBean accountBean = new AccountBean();
		accountBean.setAccountNumber(account.getAccountNumber());
		accountBean.setFirstname(account.getFirstname());
		accountBean.setLastname(account.getLastname());
		accountBean.setEmail(account.getEmail());
		accountBean.setMobilePhone(account.getMobilePhone());
		return accountBean;
	}
}
