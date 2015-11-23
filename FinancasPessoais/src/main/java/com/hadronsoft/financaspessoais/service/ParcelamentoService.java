package com.hadronsoft.financaspessoais.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.hadronsoft.financaspessoais.model.Parcelamento;
import com.hadronsoft.financaspessoais.repository.ParcelamentoRepository;
import com.hadronsoft.financaspessoais.util.Transactional;

public class ParcelamentoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ParcelamentoRepository parRepository;
	
	@Transactional
	public void salvar(Parcelamento parcelamento) throws NegocioException {
		parRepository.add(parcelamento);
	} 
	
	@Transactional
	public void excluir(Parcelamento parcelamento) throws NegocioException {
		Parcelamento obj = parRepository.getById(parcelamento.getId());
		parRepository.remove(obj);
	}

}
