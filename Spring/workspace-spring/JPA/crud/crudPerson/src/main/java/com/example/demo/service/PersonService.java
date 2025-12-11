package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.PersonModel;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
	
	private final PersonRepository personrepository;

	public PersonService(PersonRepository personrepository) {
		super();
		this.personrepository = personrepository;
	}
	
	public List<PersonModel> getPerson(){
		return this.personrepository.findAll();
	}
}
