package com.jacaranda.accesoDatos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
			model.addAttribute("contactId", contactExist);
		} catch (Exception e) {
			model.addAttribute("error", "Error:" + e.getMessage());
			
		}
		
		return "contact/list";
	}
	
	
}
