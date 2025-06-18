package com.bookmarket.dto;

public class User {

	private String id;
	private String pwd;
	private String phone;
	private String email;
	private String address;
	private String authority;
	
	public User() {
		super();
	}
	public User(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	public User(String id, String pwd, String authority) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.authority = authority;
	}
	public User(String id, String pwd, String phone, String email, String address, String authority) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.authority = authority;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
