package com.hadronsoft.financaspessoais.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.hadronsoft.financaspessoais.model.Conta;

public class ContaRepository implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

	@Inject
	public ContaRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public Conta getById(Long id){
		return this.manager.find(Conta.class, id);
	}
	
	public List<Conta> getAll(){
		return this.manager.createQuery("from Conta", Conta.class).getResultList();
	}
	
	public void add(Conta conta){
		this.manager.persist(conta);
	}
}
