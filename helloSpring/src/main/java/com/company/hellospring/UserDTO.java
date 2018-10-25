package com.company.hellospring;

public class UserDTO {
	
	private String id;
	private String password;      //user_name --> userName 으로 자동으로 바꿔주
	private String name;
	private String role;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	//이게 없으면 joinpoint 보이지 않음
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", password=" + password + ", name=" + name + ", role=" + role + "]";
	}
	
}
