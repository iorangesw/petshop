package org.petshop.dominio;


public class Cliente {

	private String nome;
	private String nomePet;
	private String model;

	public Cliente(){
		
	}
	
	public Cliente(String model, String nome, String nomePet) {
		super();
		this.model = model;
		this.nome = nome;
		this.nomePet = nomePet;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomePet() {
		return nomePet;
	}

	public void setNomePet(String nomePet) {
		this.nomePet = nomePet;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
