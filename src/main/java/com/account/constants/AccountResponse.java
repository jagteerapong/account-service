package com.account.constants;

public class AccountResponse {
	public class Code {
		public static final String SUCCESS = "0";
		public static final String NO_DATA_FOUND = "003";
		public static final String BAD_REQUEST = "400";
		public static final String INTERNAL_ERROR = "500";
	}
	
	public class Message {
		public static final String SUCCESS = "Success";
		public static final String NO_DATA_FOUND = "No data found";
		public static final String BAD_REQUEST = "Bad request";
		public static final String INTERNAL_ERROR = "Internal server error";
		public static final String ACCOUNT_DUPLICATE = "Account duplicate";
	}
}
