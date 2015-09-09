package com.hadronsoft.vendas.repositories;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.hadronsoft.vendas.model.Cliente;

public class ClienteRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Cliente getById(Long id) {
		return this.manager.find(Cliente.class, id);
	}
	
	public List<Cliente> getByNome(String nome) {
		return this.manager.createQuery("from Cliente " +
				"where upper(nome) like :nome", Cliente.class)
				.setParameter("nome", nome.toUpperCase() + "%")
				.getResultList();
	}
}
