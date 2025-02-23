package com.bharath.dating.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "User Name is mandatory")
	@Length(min = 5, max = 30, message = "User Name should be minimum 5 chars and maximum 30 char")
	private String userName;
	@NotBlank(message = "Password is mandatory")
	@Length(min = 5, max = 30, message = "Password should be minimum 5 chars and maximum 30 char")
	private String password;
	@NotNull(message = "Age is mandatory")
	@Min(value = 18, message = "Min age is 18")
	@Max(value = 45, message = "Max age is 45")
	private int age;
	@NotBlank(message = "Email is mandatory")
	@Email(message = "Provide a valid email")
	private String email;
	@NotBlank(message = "Email is mandatory")
	@Length(min = 10, max = 10, message = "Phone number should be 10 digits")
	private String phoneNumber;
	private String gender;
	private String city;
	private String country;
	@OneToOne(mappedBy = "userAccount")
	private Interest interest;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Interest getInterest() {
		return interest;
	}

	public void setInterest(Interest interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", userName=" + userName + ", password=" + password + ", age=" + age
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", gender=" + gender + ", city=" + city
				+ ", country=" + country + ", interest=" + interest + "]";
	}

}
