package com.hadronsoft.financaspessoais.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.hadronsoft.financaspessoais.model.Categoria;
import com.hadronsoft.financaspessoais.repository.CategoriaRepository;

@Named
@ViewScoped
public class CadastroCategoriaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaRepository catRepository;
	
	private Categoria categoria;
	
	private List<Categoria> categorias;
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public void prepararCadastro(){
	
		categorias = catRepository.getAll();
	}
	
	public void salvar(){
		
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
}
