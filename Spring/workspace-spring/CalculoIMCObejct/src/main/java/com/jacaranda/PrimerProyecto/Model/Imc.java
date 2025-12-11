package com.jacaranda.PrimerProyecto.Model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Imc {
	
	@Min(value=0, message="La altura debe ser mayor a 0")
	@Max(value=300, message="La altura debe ser menor a 3 m")
	@NotNull(message="este campo no puede ser nulo")
	private Double height;
	
	@Min(value=0, message="El peso debe ser mayor a 0")
	@Max(value=300, message="El peso debe ser menor a 300 kg")
	@NotNull(message="este campo no puede ser nulo")
	private Double weight;
	
	@Pattern(regexp="Hombre|Mujer", message="El campo debe ser Hombre o mujer")
	@NotNull(message="este campo no puede ser nulo")
	private String sex;
	
	@Min(value=0, message="La edad debe ser mayor a 0")
	@Max(value=120, message="La edad debe ser menor a 3 m")
	@NotNull(message="este campo no puede ser nulo")
	private Integer age;

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
