package com.hadronsoft.vendas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hadronsoft.vendas.model.Produto;
import com.hadronsoft.vendas.repositories.ProdutoRepository;
import com.hadronsoft.vendas.repositories.filters.ProdutoFilter;

@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	@Inject
	private ProdutoRepository produtoRepository;
	
	@Inject
	private ProdutoFilter filter;
	
	private List<Produto> produtosFiltrados;
	
	public PesquisaProdutosBean() {
		filter = new ProdutoFilter();
	}
	
	public void pesquisar(){
		produtosFiltrados = produtoRepository.getByFilter(filter);
	}
	
	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public ProdutoFilter getFilter() {
		return filter;
	}
	
}
