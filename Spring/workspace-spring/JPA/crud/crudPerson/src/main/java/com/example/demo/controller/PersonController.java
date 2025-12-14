package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.PersonModel;
import com.example.demo.service.PersonService;
import com.jacaranda.PrimerProyecto.Model.Imc;

@Controller
public class PersonController {

	private final PersonService personService;
		
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}


	@GetMapping("/")
	public String showView(Model model) {
		model.addAttribute("PersonModel", new PersonModel());
		model.addAttribute("listPerson", personService.getAllPerson());		
		return "index";
	}
	
	
	@GetMapping("/{id}")
	public String removeView(@PathVariable Integer id, Model model) {
		model.addAttribute("listPerson", personService.getRemovePerson(id));
		return "index";
	}

	@PostMapping("/")
	public String addPerosn(Model model,@Validated @ModelAttribute PersonModel p, BindingResult bindingresult) {
		if(bindingresult.hasErrors()) {
			return "index";
		}
		
		model.addAttribute("listPerson", personService.getAddPerson(p));
		return "index";
	}
	
	

	
}
