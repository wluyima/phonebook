package com.phonebook.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Person extends BasePersistentEntity {
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "phone_number", nullable = false, unique = true)
	private String phoneNumber;
	
	/**
	 * Gets the firstName
	 *
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the firstName
	 *
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
