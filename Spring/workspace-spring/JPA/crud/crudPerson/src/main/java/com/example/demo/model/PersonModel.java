package com.example.demo.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "persona")
public class PersonModel {

	@Id
	private Integer id;
	
	@Column(name = "nombre")
	@NotNull(message="Este campo no puede estar vacio o ser nulo")
	private String name;
	
	@Column(name = "apellido")
	@NotNull(message="Este campo no puede estar vacio o ser nulo")
	private String surname;
	
	@Column(name = "sexo")
	@NotNull(message="Este campo no puede estar vacio o ser nulo")
	private Boolean sex;

	public PersonModel() {
		super();
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
