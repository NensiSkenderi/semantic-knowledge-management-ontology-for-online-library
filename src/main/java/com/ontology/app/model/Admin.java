package com.ontology.app.model;

public class Admin {

	public String admin_first_name,admin_last_name, admin_password,admin_email,admin_id;

	
	public Admin(){
		
	}

	public String getAdmin_first_name() {
		return admin_first_name;
	}

	public void setAdmin_first_name(String admin_first_name) {
		this.admin_first_name = admin_first_name;
	}

	public String getAdmin_last_name() {
		return admin_last_name;
	}

	public void setAdmin_last_name(String admin_last_name) {
		this.admin_last_name = admin_last_name;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	public String getAdmin_email() {
		return admin_email;
	}

	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public void copy(Admin admin_copy) {
		this.setAdmin_email(admin_copy.getAdmin_email());
		this.setAdmin_first_name(admin_copy.getAdmin_first_name());
		this.setAdmin_id(admin_copy.getAdmin_id());
		this.setAdmin_last_name(admin_copy.getAdmin_last_name());
		this.setAdmin_password(admin_copy.getAdmin_password());
	}
}