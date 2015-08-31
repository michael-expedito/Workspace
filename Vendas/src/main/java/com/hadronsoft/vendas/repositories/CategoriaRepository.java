package com.hadronsoft.vendas.repositories;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.hadronsoft.vendas.model.Categoria;

public class CategoriaRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Categoria getById(Long id){
		return manager.find(Categoria.class, id);
	}
	public List<Categoria> getCategoriasRaizes() {
		return manager.createQuery("from Categoria where categoriaPai is null", Categoria.class).getResultList();
	}
	public List<Categoria> getSubCategorias(Categoria categoriapai){
		return manager.createQuery("from Categoria where categoriaPai = :categoriapai", Categoria.class)
				.setParameter("categoriapai", categoriapai).
				getResultList();
		
	}
}
