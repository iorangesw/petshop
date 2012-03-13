package org.petshop.service;

import java.util.List;

import org.petshop.dominio.Pet;

public interface PetService {
	
	public void save(Pet pet);
	
	public Pet searchPet(Long id);
	
	public void removePet(Pet pet);

	List<Pet> getAllPets();

}
