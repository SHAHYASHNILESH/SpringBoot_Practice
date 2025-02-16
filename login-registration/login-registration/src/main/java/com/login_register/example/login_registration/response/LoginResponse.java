package com.login_register.example.login_registration.response;

public class LoginResponse {

	private String message;
	private String status;

	public LoginResponse() {

	}

	public LoginResponse(String message, String status) {
		super();
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LoginResponse [message=" + message + ", status=" + status + "]";
	}
}
