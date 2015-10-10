package com.hadronsoft.financaspessoais.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.hadronsoft.financaspessoais.model.Cadastro;
import com.hadronsoft.financaspessoais.repository.CadastroRepository;

public class CadastroService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	CadastroRepository cadastroRepository;
	
	public Cadastro isCadastroReadyToLogin(String email, String senha){
		email = email.toUpperCase();
		return cadastroRepository.getByEmailSenha(email, senha);
	}
}
