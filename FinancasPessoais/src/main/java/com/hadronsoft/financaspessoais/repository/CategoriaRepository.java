package com.hadronsoft.financaspessoais.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.hadronsoft.financaspessoais.model.Cadastro;
import com.hadronsoft.financaspessoais.model.Categoria;
import com.hadronsoft.financaspessoais.security.SessionContext;

public class CategoriaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	@Inject
	public CategoriaRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Categoria getById(Long id) {
		return this.manager.find(Categoria.class, id);
	}

	public List<Categoria> getAll() {
		return this.manager.createQuery("from Categoria where cadastro = :cadastro", Categoria.class)
				.setParameter("cadastro", (Cadastro) SessionContext.getInstance().getUsuarioLogado()).getResultList();
	}

	public void add(Categoria categoria) {
		this.manager.persist(categoria);
	}

	public void update(Categoria categoria) {
		this.manager.merge(categoria);
	}

	public List<Categoria> raizes() {
		return manager.createQuery("from Categoria where categoriaPai is null", Categoria.class)
				.getResultList();
	}

}
