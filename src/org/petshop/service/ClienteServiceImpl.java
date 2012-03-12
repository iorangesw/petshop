package org.petshop.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("clienteService")
@Transactional
public class ClienteServiceImpl implements ClienteService{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void save(){
		System.out.println();
	}

}
