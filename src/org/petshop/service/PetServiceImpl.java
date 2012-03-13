package org.petshop.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.petshop.dominio.Pet;

public class PetServiceImpl implements PetService {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("petshop");

	@Override
	public void save(Pet pet) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(pet);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Pet> getAllPets() {
		EntityManager em = emf.createEntityManager();
		List<Pet> pets = null;
		try {
			em.getTransaction().begin();
			Query query = em.createQuery("SELECT pet FROM Pet pet");
			pets = query.getResultList();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return pets;
	}
	
	@Override
	public Pet searchPet(Long id) {
		EntityManager em = emf.createEntityManager();
		Pet pet = null;
		try {
			em.getTransaction().begin();
			Query query = em.createQuery("SELECT pet FROM Pet pet WHERE pet.id = "+id);
			pet = (Pet) query.getSingleResult();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return pet;
	}

	@Override
	public void removePet(Pet pet) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Pet petAble = em.find(Pet.class, pet.getId());
			em.remove(petAble);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

}
