package com.jacaranda.accesoDatos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.accesoDatos.model.Contact;
import com.jacaranda.accesoDatos.repository.ContactoRepository;

@Service
public class ContactoService {


	private final ContactoRepository contactoRepository;

	public ContactoService(ContactoRepository contactoRepository) {
		this.contactoRepository = contactoRepository;
	}
	
	public List<Contact> viewAllContacts() throws Exception{
		try {
			return contactoRepository.findAll();			
		} catch (Exception e) {
			throw new Exception("No se ha podido conectar a base de datos.");
		}
	}
	
	public Contact viewContact(Integer id) throws Exception {
		try {			
			return contactoRepository.findById(id).orElse(null);
		} catch (Exception e) {
			throw new Exception("No se ha podido contactar a base de datos.");}
		
	}
		
	public void removeContacts(Integer id) throws Exception{
		try {
			contactoRepository.deleteById(id);
		} catch (Exception e) {
			throw new Exception("No se ha podido contactar a base de datos.");
		} 
	}
	
	public List<Contact> update(Integer id, Contact contact) throws Exception {
		try {
			Contact contactExists = contactoRepository.findById(id).get();
			
			contactExists.setValue(contact.getValue());
			contactExists.setContactType(contact.getContactType());
			
			return viewAllContacts();
		} catch (Exception e) {
			throw new Exception("No se ha podido contactar a base de datos.");

		}
	}
	
	public List<Contact> getAllContactWithId(Integer id) throws Exception{
		try {
			return viewAllContacts().stream()
								.filter(c -> c.getPerson().getId().equals(id))
								.toList();
		} catch (Exception e) {
			throw new Exception("No se ha podido contactar a base de datos.");
		}
	}
	
}
