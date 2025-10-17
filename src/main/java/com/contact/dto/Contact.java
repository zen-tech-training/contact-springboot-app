package com.contact.dto;

public class Contact {
	
	private String name;
	private long mobile;
	
	public Contact() {}
	public Contact(String name, long mobile) {
		super();
		this.name = name;
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Contact [name=" + name + ", mobile=" + mobile + "]";
	}
}

