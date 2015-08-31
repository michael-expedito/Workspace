package com.hadronsoft.financaspessoais.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hadronsoft.financaspessoais.model.Categoria;

@Named
@ViewScoped
public class CadastroCategoriaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private List<Categoria> categoria;
	
	public List<Categoria> getCategoria() {
		return categoria;
	}
	
	public void carregarCategoria(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("FinancasPessoaisPU");
		EntityManager manager = factory.createEntityManager();
		
		categoria = manager.createQuery("from Categoria", Categoria.class).getResultList();

		manager.close();
	}

	public CadastroCategoriaBean() {
		
	}
	
	public void salvar(){
		
	}
}
