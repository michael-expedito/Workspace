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
		//Preenchendo categoria
		categoria.setCadastro((Cadastro) SessionContext.getInstance().getUsuarioLogado());
		categoria.setTipoCategoria(TipoCategoria.ANALITICA);
		if (categoria.getCategoriaPai() != null){
			categoria.setNivel(categoria.getCategoriaPai().getNivel()+1);
			categoria.setOrdenacao(categoria.getCategoriaPai().getOrdenacao()+1);
			categoria.getCategoriaPai().setTipoCategoria(TipoCategoria.SINTETICA);
		} else {
			categoria.setNivel(0);
			categoria.setOrdenacao(catRepository.getUltimaOrdenacao(categoria.getCadastro())+1);
		}
		
		if (categoria.getCategoriaPai() != null){
			this.catRepository.incrementaOrdenacaoCategorias(categoria.getCategoriaPai());
		}
		
		this.catRepository.update(categoria);
		
		if (categoria.getCategoriaPai() != null){
			this.catRepository.update(categoria.getCategoriaPai());
		}
		
		FacesUtil.addInfoMessage("Categoria cadastrada com sucesso!");
		
	}
	
	@Transactional
	public void excluir(Categoria categoria) throws NegocioException {
		this.catRepository.delete(categoria);
	}

}
