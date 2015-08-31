package com.hadronsoft.vendas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import com.hadronsoft.vendas.model.Categoria;
import com.hadronsoft.vendas.model.Produto;
import com.hadronsoft.vendas.repositories.CategoriaRepository;
import com.hadronsoft.vendas.services.CadastroProdutoService;
import com.hadronsoft.vendas.util.jsf.FacesUtil;

@Named
@SessionScoped
public class CadastroProdutosBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriaRepository categoriaRepository;
	
	@Inject
	private CadastroProdutoService cadastroProdutoService;
	
	private Categoria categoriaPai;
	
	private Produto produto;
	
	private List<Categoria> categoriasRaizes;
	private List<Categoria> subcategorias;
	
	public CadastroProdutosBean(){
		limpar();
	}
	
	public void inicializar() {
		if (FacesUtil.isNotPostback()){
			limpar();
			categoriasRaizes = categoriaRepository.getCategoriasRaizes();
			
			if(this.categoriaPai != null){
				carregarSubcategorias();
			}
		}
	}
	private void limpar(){
		this.produto = new Produto();
		categoriaPai = null;
		subcategorias = new ArrayList<>();
	}
	
	public void carregarSubcategorias(){
		if(this.produto != null){
			subcategorias = categoriaRepository.getSubCategorias(categoriaPai);
		}
	}
	
	public void salvar(){
		this.produto = cadastroProdutoService.salvar(this.produto);
		limpar();
		FacesUtil.addInfoMessage("Produto salvo com sucesso!");	
	}

	public Produto getProduto() {
		return this.produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
		
		if (this.produto != null){
			this.categoriaPai = this.produto.getCategoria().getCategoriaPai();
		}
	}

	public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}
	
	@NotNull
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}
	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}
	public void setSubcategorias(List<Categoria> subcategorias) {
		this.subcategorias = subcategorias;
	}
	
	public boolean isEditando() {
		return this.produto.getId() != null;
	}
	
}
