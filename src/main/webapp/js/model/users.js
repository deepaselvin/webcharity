package com.revature.webcharityapp.projectdept2.model;

public class RegUserDetails {

	private String name;
	private long phone_no;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneno() {
		return phone_no;
	}

	public void setPhoneno(long phnoneno) {
		this.phone_no = phnoneno;
		
	}


	@Override
	public String toString() {
		return "RegUserDetails [name=" + name + ", phone_no=" + phone_no + "]";
	}

	


	



}
