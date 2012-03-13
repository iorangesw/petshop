package org.petshop.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.petshop.dominio.Pet;
import org.petshop.service.PetService;
import org.petshop.service.PetServiceImpl;

@ManagedBean(name="petBean")
@SessionScoped
public class PetBean {

	private Pet pet;
	private Pet selectedPet;
	private PetService petService = new PetServiceImpl();

	public String cadastrarPet(){
		pet = new Pet();
		return "/pages/forms/cadastrar_pet.xhtml";
	}
	
	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public List<Pet> getPets() {
		return petService.getAllPets();
	}
	
	public void salvar(){
		petService.save(pet);
		cadastrarPet();
	}
	
	public void editar(){
		
	}
	
	public void excluir(){
		petService.removePet(pet);
		cadastrarPet();
	}

	public Pet getSelectedPet() {
		return selectedPet;
	}

	public void setSelectedPet(Pet selectedPet) {
		this.selectedPet = selectedPet;
	}
	
}
