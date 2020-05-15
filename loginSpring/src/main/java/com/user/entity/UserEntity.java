package com.user.entity;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Userr")
public class UserEntity {
	@Id
	private String id;
	private String type;
	private String name;
	private String password;
	private BigInteger phone;
	private String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BigInteger getPhone() {
		return phone;
	}
	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserEntity(String id, String type, String name, String password, BigInteger phone, String email)
	{
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}
	
	public UserEntity()
	{
		
	}
	
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", type=" + type + ", name=" + name + ", password=" + password + ", phone="
				+ phone + ", email=" + email + "]";
	}
	
}
