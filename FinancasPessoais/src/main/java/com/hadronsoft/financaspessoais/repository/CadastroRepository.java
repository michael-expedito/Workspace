package com.hadronsoft.financaspessoais.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.hadronsoft.financaspessoais.model.Cadastro;

public class CadastroRepository implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

	@Inject
	public CadastroRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public Cadastro getByEmailSenha(String email, String senha){
		try {
			return this.manager.createQuery("from Cadastro where upper(email) = :email and senha = :senha", Cadastro.class)
					.setParameter("email", email)
					.setParameter("senha", senha)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}
	
	

}
