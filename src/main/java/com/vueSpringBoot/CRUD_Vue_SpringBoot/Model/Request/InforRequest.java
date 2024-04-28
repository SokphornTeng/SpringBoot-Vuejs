package com.vueSpringBoot.CRUD_Vue_SpringBoot.Model.Request;

import java.io.Serializable;

import com.vueSpringBoot.CRUD_Vue_SpringBoot.Model.Entity.Enums;
import com.vueSpringBoot.CRUD_Vue_SpringBoot.Model.Entity.Information;

public class InforRequest implements Serializable{

	private String firstName;
	private String lastName;
	private Integer age;
	private Enums gender;
	private String email;
	private String address;
	private String status;
	
	public InforRequest(String firstName, String lastName, Integer age, String email, Enums gender, String address, String status) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.status = status;
	}

	public Information InforReq() {
		Information info = new Information();
		info.setFirstName(this.firstName);
		info.setLastName(this.lastName);
		info.setAge(this.age);
	    info.setGender(this.gender);
		info.setEmail(this.email);
		info.setAddress(this.address);
		info.setStatus(this.status);
		return info;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Enums getGender() {
		return gender;
	}

	public void setGender(Enums gender) {
		this.gender = gender;
	}
	
	
	
}
