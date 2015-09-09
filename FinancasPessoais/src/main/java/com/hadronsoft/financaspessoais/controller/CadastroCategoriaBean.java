package com.hadronsoft.financaspessoais.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.hadronsoft.financaspessoais.model.Categoria;
import com.hadronsoft.financaspessoais.repository.CategoriaRepository;

@Named
@ViewScoped
public class CadastroCategoriaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaRepository catRepository;
	
	private Categoria categoria;
	
	private List<Categoria> categoriasPai;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
