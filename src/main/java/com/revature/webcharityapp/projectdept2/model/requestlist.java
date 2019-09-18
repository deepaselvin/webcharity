package com.revature.webcharityapp.projectdept2.model;

public class requestlist {
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	private int id;
	@Override
	public String toString() {
		return "requestlist [id=" + id + ",name=" + name + "]";
	}
}
