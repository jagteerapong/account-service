package com.account.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.account.constants.AccountResponse;
import com.account.model.response.ResponseMessage;

import jakarta.persistence.NoResultException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler({Exception.class})
	public ResponseEntity<ResponseMessage> handleException(Exception ex) {
		ResponseMessage response = new ResponseMessage();
		response.setCode(AccountResponse.Code.INTERNAL_ERROR);
		response.setMessage(ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler({NoResultException.class})
	public ResponseEntity<ResponseMessage> handleNoResultException(NoResultException ex) {
		ResponseMessage response = new ResponseMessage();
		response.setCode(AccountResponse.Code.NO_DATA_FOUND);
		response.setMessage(AccountResponse.Message.NO_DATA_FOUND);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@ExceptionHandler({SystemLogonNotValidException.class})
	public ResponseEntity<ResponseMessage> handleSystemLogonNotValidException(SystemLogonNotValidException ex) {
		ResponseMessage response = new ResponseMessage();
		response.setCode(AccountResponse.Code.SYSTEM_LOGON_NOT_VALID);
		response.setMessage(AccountResponse.Message.SYSTEM_LOGON_NOT_VALID);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ResponseMessage response = new ResponseMessage();
		response.setCode(AccountResponse.Code.BAD_REQUEST);
		response.setMessage(AccountResponse.Message.BAD_REQUEST);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
