package com.phonebook.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.model.Person;
import com.phonebook.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PersonService service;
	
	@GetMapping
	public List<Person> getAll() {
		log.info("Fetching all persons");
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public Person get(@PathVariable("id") Integer id) {
		log.info("Looking up person with id: " + id);
		return service.getById(id);
	}
	
	@PostMapping
	public Person create(@RequestBody Person person) {
		log.info("Creating new person");
		return service.save(person);
	}
	
	@PostMapping("/{id}")
	public Person update(@RequestBody Person person, @PathVariable("id") Integer id) {
		log.info("Updating person with id: " + id);
		return service.save(person);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		log.info("Deleting person with id: " + id);
		service.delete(service.getById(id));
	}
	
}
