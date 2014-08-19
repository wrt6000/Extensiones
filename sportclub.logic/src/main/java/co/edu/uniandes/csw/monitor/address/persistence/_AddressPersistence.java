/* ========================================================================
 * Copyright 2014 monitor
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 monitor

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201408112050

*/

package co.edu.uniandes.csw.monitor.address.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.monitor.address.logic.dto.AddressDTO;
import co.edu.uniandes.csw.monitor.address.persistence.api._IAddressPersistence;
import co.edu.uniandes.csw.monitor.address.persistence.converter.AddressConverter;
import co.edu.uniandes.csw.monitor.address.persistence.entity.AddressEntity;

public abstract class _AddressPersistence implements _IAddressPersistence {

  	@PersistenceContext(unitName="sportclubPU")
 
	protected EntityManager entityManager;
	
	public AddressDTO createAddress(AddressDTO address) {
		AddressEntity entity=AddressConverter.persistenceDTO2Entity(address);
		entityManager.persist(entity);
		return AddressConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<AddressDTO> getAddresss() {
		Query q = entityManager.createQuery("select u from AddressEntity u");
		return AddressConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public AddressDTO getAddress(Long id) {
		return AddressConverter.entity2PersistenceDTO(entityManager.find(AddressEntity.class, id));
	}

	public void deleteAddress(Long id) {
		AddressEntity entity=entityManager.find(AddressEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateAddress(AddressDTO detail) {
		AddressEntity entity=entityManager.merge(AddressConverter.persistenceDTO2Entity(detail));
		AddressConverter.entity2PersistenceDTO(entity);
	}

}