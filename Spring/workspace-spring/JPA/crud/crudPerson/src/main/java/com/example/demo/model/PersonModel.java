package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona")
public class PersonModel {

	@Id
	private Integer id;
	
	@Column(name = "nombre")
	private String name;
	
	@Column(name = "apellido")
	private String surname;
	
	@Column(name = "sexo")
	private Boolean sex;

	public PersonModel(Integer id, String name, String surname, Boolean sex) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.sex = sex;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	
	
}
