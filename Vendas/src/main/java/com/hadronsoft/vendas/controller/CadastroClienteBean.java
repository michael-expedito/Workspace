package com.hadronsoft.vendas.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.hadronsoft.vendas.model.Cliente;
import com.hadronsoft.vendas.pattern.CadastroBean;

@Named
@ViewScoped
public class CadastroClienteBean implements Serializable, CadastroBean  {
	
	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTitlePage() {
		// TODO Auto-generated method stub
		return null;
	}

	//getters and setters
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	
}
