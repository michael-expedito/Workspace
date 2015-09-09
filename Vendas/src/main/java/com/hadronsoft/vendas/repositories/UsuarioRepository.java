package com.hadronsoft.vendas.repositories;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.hadronsoft.vendas.model.Usuario;

public class UsuarioRepository implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Usuario getById(Long id) {
		return this.manager.find(Usuario.class, id);
	}
	
	public List<Usuario> getVendedores() {
		return this.manager.createQuery("from Usuario", Usuario.class)
				.getResultList();
	}

}
