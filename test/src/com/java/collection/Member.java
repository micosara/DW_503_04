package com.java.collection;

public class Member {

	private String id;
	private String pwd;
	private String name;
	
	public Member(String id, String pwd, String name) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member other = (Member)obj;
			return other.getId().equals(this.id);
		}
		return false;
	}

	@Override
	public String toString() {
		return this.id+"("+this.pwd+")";
	}
	
	
}






