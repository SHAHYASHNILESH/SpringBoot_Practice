package com.login_register.example.login_registration.dto;

public class EmployeeRequest {

//	private int employee_id;
	private String employee_name;
	private String employee_email;
	private String employee_password;

	public EmployeeRequest() {
		super();
	}

	public EmployeeRequest(String employee_name, String employee_email, String employee_password) {
		super();
//		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_email = employee_email;
		this.employee_password = employee_password;
	}

//	public int getEmployee_id() {
//		return employee_id;
//	}
//
//	public void setEmployee_id(int employee_id) {
//		this.employee_id = employee_id;
//	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}

	public String getEmployee_password() {
		return employee_password;
	}

	public void setEmployee_password(String employee_password) {
		this.employee_password = employee_password;
	}

	@Override
	public String toString() {
		return "EmployeeRequest [employee_name=" + employee_name + ", employee_email=" + employee_email
				+ ", employee_password=" + employee_password + "]";
	}

}
