package com.hadronsoft.financaspessoais.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.hadronsoft.financaspessoais.model.Parcelamento;

public class ParcelamentoRepository  implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

	@Inject
	public ParcelamentoRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public void add(Parcelamento parcelamento) {
		this.manager.persist(parcelamento);
	}

	public void update(Parcelamento parcelamento) {
		this.manager.merge(parcelamento);
		
	}
	
	public void remove(Parcelamento parcelamento){
		this.manager.remove(this.manager.getReference(Parcelamento.class, parcelamento.getId()));
	}

	public Parcelamento getById(Long id) {
		return this.manager.find(Parcelamento.class, id);
	}
}
