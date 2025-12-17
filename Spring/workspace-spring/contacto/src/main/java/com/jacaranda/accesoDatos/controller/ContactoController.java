package com.jacaranda.accesoDatos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.accesoDatos.model.Contact;
import com.jacaranda.accesoDatos.service.ContactoService;

@Controller
@RequestMapping("contact")
public class ContactoController {

	private ContactoService contactoService;

	public ContactoController(ContactoService contactoService) {
		super();
		this.contactoService = contactoService;
	}
	
	@GetMapping("/list")
	public String showView(Model model) {
		
		try {
			List<Contact> contacts = contactoService.viewAllContacts();
			model.addAttribute("contacts", contacts);
		} catch (Exception e) {
			model.addAttribute("error", "Error:" + e.getMessage());
			
		}
		
		return "contact/list";
	}

	@GetMapping("/edit/{id}")
	public String showViewEdit(Model model, @PathVariable Integer id) {
		
		try {
			Contact contactExist = contactoService.viewContact(id);
			model.addAttribute("action", "edit" );
			model.addAttribute("contact", contactExist);
		} catch (Exception e) {
			model.addAttribute("error", "Error:" + e.getMessage());
			
		}
		
		return "contact/form";
	}
	
	@PostMapping("/edit/{id}")
	public String edit(Model model,Contact contactUpdate,BindingResult result, @PathVariable Integer id) {
		
		try {
			Contact contactExist = contactoService.viewContact(id);
			List<Contact> contacts = contactoService.update(id,contactUpdate);
			model.addAttribute("contacts", contacts);
		} catch (Exception e) {
			model.addAttribute("error", "Error:" + e.getMessage());
		}
		
		return "contact/list";
	}
	
	@GetMapping("/new")
	public String newContact(Model model) {
		model.addAttribute("contact", new Contact());
		model.addAttribute("action", "create");
		return "contact/form";
	}
	
	
	@GetMapping("/delete{id}")
	public String showViewDelete(Model model, @RequestParam Integer id) {
		
		try {
			Contact contactExist = contactoService.viewContact(id);


			model.addAttribute("action", "delete" );
			model.addAttribute("contact", contactExist);
		} catch (Exception e) {
			model.addAttribute("error", "Error:" + e.getMessage());
			
		}
		
		return "contact/form";
	}
	
	@GetMapping("/details{id}")
	public String showViewDetails(Model model, @RequestParam Integer id) {
		
		try {
			Contact contactExist = contactoService.viewContact(id);
			model.addAttribute("contacts", contactoService.getAllContactWithId(id));
		} catch (Exception e) {
			model.addAttribute("error", "Error:" + e.getMessage());
			
		}
		
		return "contact/list";
	}
	
}
