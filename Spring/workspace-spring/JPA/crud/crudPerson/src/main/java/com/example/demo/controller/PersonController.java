package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;

@Controller
public class PersonController {

	private final PersonService personService;
		
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}


	@GetMapping("/")
	public String showView(Model model) {
		
		model.addAttribute("listPerson", personService.getPerson());		
		return "index";
	}


	public PersonService getPersonService() {
		return personService;
	}
	
	

	
}
