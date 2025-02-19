package com.account.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.constants.AccountResponse;
import com.account.model.request.CreateRequest;
import com.account.model.request.DeleteRequest;
import com.account.model.request.InquiryRequest;
import com.account.model.request.UpdateEmailRequest;
import com.account.model.request.UpdateMobileRequest;
import com.account.model.response.AccountBean;
import com.account.model.response.CreateResponse;
import com.account.model.response.DeleteResponse;
import com.account.model.response.InquiryResponse;
import com.account.model.response.UpdateEmailResponse;
import com.account.model.response.UpdateMobileResponse;
import com.account.service.AccountService;
import com.account.service.AuthenSystemLogonService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/account", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountController {
	
	private final AuthenSystemLogonService authenSystemLogonService;
	private final AccountService accountService;
	
	public AccountController(
			AuthenSystemLogonService authenSystemLogonService,
			AccountService accountService) {
		this.authenSystemLogonService = authenSystemLogonService;
		this.accountService = accountService; 
	}

	@Operation(summary = "Create account")
	@ApiResponse(responseCode = AccountResponse.Code.SUCCESS, description = AccountResponse.Message.SUCCESS)
	@PostMapping(value = "/create")
	public ResponseEntity<CreateResponse> create(@Valid @RequestBody CreateRequest request) throws Exception {
		try {
			authenSystemLogonService.isSystemLogonActive(request.getSystemName());
			accountService.createAccount(request);
		} catch (Exception e) {
			throw e;
		}
		return new ResponseEntity<>(new CreateResponse(), HttpStatus.OK);
	}
	
	@Operation(summary = "Update mobile phone")
	@ApiResponse(responseCode = AccountResponse.Code.SUCCESS, description = AccountResponse.Message.SUCCESS)
	@PostMapping(value = "/update/mobile")
	public ResponseEntity<UpdateMobileResponse> updateMobile(@Valid @RequestBody UpdateMobileRequest request) throws Exception {
		try {
			authenSystemLogonService.isSystemLogonActive(request.getSystemName());
			accountService.updateMobile(request);
		} catch (Exception e) {
			throw e;
		}
		return new ResponseEntity<>(new UpdateMobileResponse(), HttpStatus.OK);
	}
	
	@Operation(summary = "Update email")
	@ApiResponse(responseCode = AccountResponse.Code.SUCCESS, description = AccountResponse.Message.SUCCESS)
	@PostMapping(value = "/update/email")
	public ResponseEntity<UpdateEmailResponse> updateEmail(@Valid @RequestBody UpdateEmailRequest request) throws Exception {
		try {
			authenSystemLogonService.isSystemLogonActive(request.getSystemName());
			accountService.updateEmail(request);
		} catch (Exception e) {
			throw e;
		}
		return new ResponseEntity<>(new UpdateEmailResponse(), HttpStatus.OK);
	}
	
	@Operation(summary = "Delete account")
	@ApiResponse(responseCode = AccountResponse.Code.SUCCESS, description = AccountResponse.Message.SUCCESS)
	@PostMapping(value = "/delete")
	public ResponseEntity<DeleteResponse> delete(@Valid @RequestBody DeleteRequest request) throws Exception {
		try {
			authenSystemLogonService.isSystemLogonActive(request.getSystemName());
			accountService.deleteAccount(request);
		} catch (Exception e) {
			throw e;
		}
		return new ResponseEntity<>(new DeleteResponse(), HttpStatus.OK);
	}
	
	@Operation(summary = "Inquiry account data by account")
	@ApiResponse(responseCode = AccountResponse.Code.SUCCESS, description = AccountResponse.Message.SUCCESS)
	@PostMapping(value = "/inquiry/accountNumber")
	public ResponseEntity<InquiryResponse> inquiry(@Valid @RequestBody InquiryRequest request) throws Exception {
		InquiryResponse response = new InquiryResponse();
		try {
			authenSystemLogonService.isSystemLogonActive(request.getSystemName());
			AccountBean account = accountService.getAccountByAccountNumber(request.getAccountNumber());
			response.setAccount(account);
		} catch (Exception e) {
			throw e;
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
