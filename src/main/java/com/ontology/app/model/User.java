package com.ontology.app.model;

public class User {

	private String user_id,email, first_name,last_name, password,phone_number;
    private String country, city, address;
	public User() {
		
	}
	public User(String user_id,String email, String first_name, String last_name, String password, String phone_number, String city,
			String country, String address) {
		this.user_id = user_id;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.phone_number = phone_number;
		this.city = city;
		this.address = address;
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void copy(User user_copy) {
		this.setEmail(user_copy.getEmail());
		this.setFirst_name(user_copy.getFirst_name());
		this.setLast_name(user_copy.getLast_name());
		this.setPassword(user_copy.getPassword());
		this.setPhone_number(user_copy.getPhone_number());
		this.setAddress(user_copy.getAddress());
		this.setCity(user_copy.getCity());
		this.setCountry(user_copy.getCountry());
		
	}
	
	
}
