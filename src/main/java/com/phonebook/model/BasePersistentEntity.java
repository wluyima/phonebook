package com.phonebook.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BasePersistentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * Gets the id
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets the id
	 *
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		if (getId() == null) {
			return super.hashCode();
		}
		
		return getId().hashCode();
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || !getClass().isAssignableFrom(other.getClass())) {
			return false;
		}
		
		BasePersistentEntity otherObj = (BasePersistentEntity) other;
		if (getId() == null && otherObj.getId() == null) {
			return super.equals(other);
		}
		
		return this.getId().equals(otherObj.getId());
	}
}
