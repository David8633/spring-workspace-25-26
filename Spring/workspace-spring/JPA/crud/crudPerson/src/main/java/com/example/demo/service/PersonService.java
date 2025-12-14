package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.PersonModel;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
	
	private final PersonRepository personrepository;

	public PersonService(PersonRepository personrepository) {
		this.personrepository = personrepository;
	}
	
	public List<PersonModel> getAllPerson(){
		return this.personrepository.findAll();
	}
	
	public List<PersonModel> getRemovePerson(Integer id){
		this.personrepository.deleteById(id);
		return getAllPerson();
	}
	
	public List<PersonModel> getAddPerson(PersonModel p){
		this.personrepository.save(p);
		return getAllPerson();
	}
	
}
