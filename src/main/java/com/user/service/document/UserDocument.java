package com.user.service.document;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("USER")
public class UserDocument {
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private Long userId;
	
	private String firstName;
	private String lastName;
	private String phone;
	private String emailId;
	private String password;
	private LocalDateTime dob;
	private String gender;
	
	public UserDocument() {
		super();
	}

	public UserDocument(Long userId, String firstName, String lastName, String phone, String emailId, String password,
			LocalDateTime dob, String gender) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.emailId = emailId;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getDob() {
		return dob;
	}

	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
		
}
