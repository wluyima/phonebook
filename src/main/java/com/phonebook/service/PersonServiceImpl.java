package com.phonebook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.dao.PersonRepository;
import com.phonebook.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository repo;
	
	@Override
	public Person getById(Integer id) {
		return repo.findById(id).orElse(null);
	}
	
	@Override
	public List<Person> getAll() {
		return (List<Person>) repo.findAll();
	}
	
	@Override
	public Person save(Person person) {
		return repo.save(person);
	}
	
	@Override
	public void delete(Person person) {
		repo.delete(person);
	}
}
