package com.contact.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.contact.dto.Contact;

@RestController
@CrossOrigin(origins="*")
public class ContactController {
	
	private static List<Contact> contactList = new ArrayList<Contact>();
	private static int contactIdCounter = 0;
	static {
		contactList.add(new Contact("Tom", 11111));
		contactList.add(new Contact("Jerry", 22222));
		contactList.add(new Contact("Bipin", 33333));
		contactList.add(new Contact("Vivek", 44444));
	}

	@GetMapping("/contact")
	public ResponseEntity<List<Contact>> getAllContacts() {
		return new ResponseEntity<List<Contact>>(contactList, HttpStatus.OK);
	}

	@GetMapping("/contact/{id}")
	public Contact getContactById(@PathVariable(value="name") String contactName) {
		List<Contact> filteredContactList = contactList.stream().filter((contact)->contact.getName().equalsIgnoreCase(contactName)).collect(Collectors.toList());
		if(filteredContactList == null || filteredContactList.size() == 0) {
			return null;
		}
		else {
			return filteredContactList.get(0);
		}
	}

	@PostMapping(value="/contact", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contact> createNewContact(@RequestBody Contact contact) {
		contactList.add(contact);
		System.out.println("createNewContact(): " + contact);
		return new ResponseEntity<Contact>(contact, HttpStatus.CREATED);
	}

}
