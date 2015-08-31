package com.hadronsoft.financaspessoais.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.hadronsoft.financaspessoais.model.Lancamento;

public class LancamentoRepository implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

	@Inject
	public LancamentoRepository(EntityManager manager) {
		this.manager = manager;
	}

	public List<Lancamento> getAll() {
		TypedQuery<Lancamento> query = manager.createQuery("from Lancamento", Lancamento.class);
		return query.getResultList();
	}
	
	public Lancamento getById(Long id){
		return this.manager.find(Lancamento.class, id);
	}
	
	public void add(Lancamento lancamento) {
		this.manager.persist(lancamento);
	}
	
	public Lancamento update (Lancamento lancamento){
		return this.manager.merge(lancamento);
	}
	
	public void delete(Lancamento lancamento) {
		this.manager.remove(lancamento);
	}
	
	
}
