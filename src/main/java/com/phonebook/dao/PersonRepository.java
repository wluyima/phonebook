package com.phonebook.dao;

import org.springframework.data.repository.CrudRepository;

import com.phonebook.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer> {
	
}
