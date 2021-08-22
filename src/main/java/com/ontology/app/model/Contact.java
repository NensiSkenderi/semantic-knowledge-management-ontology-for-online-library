package com.ontology.app.model;

public class Contact {

	String full_name,email,phone_number, message;

	public Contact(String full_name, String email, String phone_number, String message) {
		
		this.full_name = full_name;
		this.email = email;
		this.phone_number = phone_number;
		this.message = message;
	}

	public Contact() {
		
	}
	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
