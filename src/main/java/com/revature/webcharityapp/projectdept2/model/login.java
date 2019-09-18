package com.revature.webcharityapp.projectdept2.model;

import lombok.Data;

@Data
public class login {
	private String name;
	private int phone_no;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(int phone_no) {
		this.phone_no = phone_no;
	}
}
