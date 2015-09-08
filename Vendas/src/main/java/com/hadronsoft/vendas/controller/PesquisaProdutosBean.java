package com.hadronsoft.vendas.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hadronsoft.vendas.model.Produto;
import com.hadronsoft.vendas.repositories.ProdutoRepository;
import com.hadronsoft.vendas.repositories.filters.ProdutoFilter;
import com.hadronsoft.vendas.services.CadastroProdutoService;
import com.hadronsoft.vendas.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaProdutosBean implements Serializable{
	
	private static final long serialVersionUID = 1L; 
	
	@Inject
	private ProdutoRepository produtoRepository;
	
	@Inject
	private ProdutoFilter filter;
	
	@Inject
	private CadastroProdutoService cadastroProdutoService;
	
	private List<Produto> produtosFiltrados;
	
	private Produto produtoSelecionado;
	
	public PesquisaProdutosBean() {
		filter = new ProdutoFilter();
	}
	
	public void pesquisar(){
		produtosFiltrados = produtoRepository.getByFilter(filter);
	}
	
	public void excluir(){
		System.out.println(produtoSelecionado.getId().toString());
		cadastroProdutoService.excluir(produtoSelecionado);
		produtosFiltrados.remove(produtoSelecionado);
		
		FacesUtil.addInfoMessage("Produto excluido com sucesso!");
	}
	
	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public ProdutoFilter getFilter() {
		return filter;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	
	
	
}
