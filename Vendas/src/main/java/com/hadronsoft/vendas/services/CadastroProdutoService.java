package com.hadronsoft.vendas.services;

import java.io.Serializable;

import javax.inject.Inject;

import com.hadronsoft.vendas.model.Produto;
import com.hadronsoft.vendas.repositories.ProdutoRepository;
import com.hadronsoft.vendas.util.jpa.Transactional;

public class CadastroProdutoService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProdutoRepository produtoRepository;
	
	@Transactional
	public Produto salvar(Produto produto) {
		
		return produtoRepository.update(produto);
	}
	
	@Transactional
	public void excluir(Produto produto){
		produtoRepository.delete(produto);
	}
}
