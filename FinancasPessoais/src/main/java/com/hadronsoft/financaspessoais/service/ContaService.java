package com.hadronsoft.financaspessoais.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.hadronsoft.financaspessoais.model.Conta;
import com.hadronsoft.financaspessoais.repository.ContaRepository;
import com.hadronsoft.financaspessoais.util.Transactional;

public class ContaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ContaRepository ctaRepository;
	
	@Transactional
	public void salvar(Conta conta) throws NegocioException {
		this.ctaRepository.update(conta);
	}
	
	@Transactional
	public void excluir(Conta conta) throws NegocioException {
		this.ctaRepository.delete(conta);
	}
}
