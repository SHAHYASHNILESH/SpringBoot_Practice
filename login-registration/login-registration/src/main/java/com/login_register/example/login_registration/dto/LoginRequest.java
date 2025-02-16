package com.login_register.example.login_registration.dto;

public class LoginRequest {

	private String employeeEmail;
	private String employeePassword;

	public LoginRequest() {
		super();
	}

	public LoginRequest(String employee_email, String employee_password) {
		super();
		this.employeeEmail = employee_email;
		this.employeePassword = employee_password;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employee_email) {
		this.employeeEmail = employee_email;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employee_password) {
		this.employeePassword = employee_password;
	}

	@Override
	public String toString() {
		return "LoginRequest [employee_email=" + employeeEmail + ", employee_password=" + employeePassword + "]";
	}

}
