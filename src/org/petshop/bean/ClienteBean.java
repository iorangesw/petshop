package org.petshop.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name="clienteBean")
public class ClienteBean {
	
	public String cadastrarCliente(){
		return "/pages/forms/cadastrar_cliente.xhtml";
	}

}
