package com.account.model.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class ResponseMessage {
	@Schema(description = "Response code", example = "0")
	private String code;
	
	@Schema(description = "Response message", example = "Success")
	private String message;
	
	public ResponseMessage() {
		this.code = "0";
		this.message = "Success";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
