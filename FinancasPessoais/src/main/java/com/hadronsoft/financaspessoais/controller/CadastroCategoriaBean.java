package com.hadronsoft.financaspessoais.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hadronsoft.financaspessoais.model.Categoria;
import com.hadronsoft.financaspessoais.repository.CategoriaRepository;
import com.hadronsoft.financaspessoais.service.CategoriaService;
import com.hadronsoft.financaspessoais.service.NegocioException;

@Named
@ViewScoped
public class CadastroCategoriaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaRepository catRepository;
	
	@Inject
	private CategoriaService catService;
	
	private Categoria categoria;
	
	private List<Categoria> categorias;
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public void prepararCadastro(){
	
		categoria  = new Categoria();
		categoria.setCategoriaPai(new Categoria());
		categorias = catRepository.getAll();
	}
	
	public void salvar() throws NegocioException{
		this.catService.salvar(categoria);
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
}
