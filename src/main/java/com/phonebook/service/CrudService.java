/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 * <p>
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package com.phonebook.service;

import java.util.List;

import com.phonebook.model.BasePersistentEntity;

public interface CrudService<T extends BasePersistentEntity> {
	
	T getById(Integer id);
	
	List<T> getAll();
	
	T save(T object);
	
	void delete(T object);
	
}
