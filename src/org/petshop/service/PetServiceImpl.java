package org.petshop.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.petshop.dominio.Pet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("petService")
public class PetServiceImpl implements PetService {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("petshop");

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Pet pet) {
		entityManager.merge(pet);
	}

	@Override
	public List<Pet> getAllPets() {
		Query query = entityManager.createQuery("SELECT pet FROM Pet pet");
		return query.getResultList();
	}

	@Override
	public Pet searchPet(Long id) {
		Query query = entityManager.createQuery("SELECT pet FROM Pet pet WHERE pet.id = "+id);
		return (Pet) query.getSingleResult();
	}

	@Override
	public void removePet(Pet pet) {
		Pet petAble = entityManager.find(Pet.class, pet.getId());
		entityManager.remove(petAble);
	}
}
