package com.hadronsoft.financaspessoais.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.hadronsoft.financaspessoais.model.Cadastro;
import com.hadronsoft.financaspessoais.model.Categoria;
import com.hadronsoft.financaspessoais.model.TipoCategoria;
import com.hadronsoft.financaspessoais.repository.CategoriaRepository;
import com.hadronsoft.financaspessoais.security.SessionContext;
import com.hadronsoft.financaspessoais.util.FacesUtil;
import com.hadronsoft.financaspessoais.util.Transactional;

public class CategoriaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriaRepository catRepository;
	
	@Transactional
	public void salvar(Categoria categoria) throws NegocioException {
		
		categoria.setNivel(categoria.getCategoriaPai().getNivel()+1);
		categoria.setTipoCategoria(TipoCategoria.ANALITICA);
		categoria.setOrdenacao(categoria.getCategoriaPai().getOrdenacao()+1);
		categoria.setCadastro((Cadastro) SessionContext.getInstance().getUsuarioLogado());
		this.catRepository.incrementaOrdenacaoCategorias(categoria.getCategoriaPai());
		this.catRepository.update(categoria);
		categoria.getCategoriaPai().setTipoCategoria(TipoCategoria.SINTETICA);
		this.catRepository.update(categoria.getCategoriaPai());
		
		
		FacesUtil.addInfoMessage("Categoria cadastrada com sucesso!");
		
	}
	
	@Transactional
	public void excluir(Categoria categoria) throws NegocioException {
		this.catRepository.delete(categoria);
	}

}
