package com.vueSpringBoot.CRUD_Vue_SpringBoot.Model.Response;

import java.io.Serializable;

import com.vueSpringBoot.CRUD_Vue_SpringBoot.Model.Entity.Enums;
import com.vueSpringBoot.CRUD_Vue_SpringBoot.Model.Entity.Information;

public class InforResponse implements Serializable {

	private Long id;
	private String firstName;
	private String lastName;
	private Integer age;
	private Enums gender;
	private String email;
	private String address;
	private String status;
	
	public InforResponse() {
		super();
	}
	
	public InforResponse(Long id, String firstName, String lastName, Integer age, Enums gender, String email,
			String address, String status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.status = status;
	}
	
	public static InforResponse infoResponse(Information info) {
		
		return new InforResponse(
				info.getId(),
				info.getFirstName(),
				info.getLastName(),
				info.getAge(),
				info.getGender(),
				info.getEmail(),
				info.getAddress(),
				info.getStatus()
				);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Enums getGender() {
		return gender;
	}

	public void setGender(Enums gender) {
		this.gender = gender;
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
	
	
}
