package com.hadronsoft.financaspessoais.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hadronsoft.financaspessoais.model.Conta;
import com.hadronsoft.financaspessoais.repository.ContaRepository;

@Named
@SessionScoped
public class ConsultaContasBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	ContaRepository ctaRepository;
	
	private List<Conta> contas;
	
	private Conta contaSelecionada;
	
	public void consultar(){
		this.contas = ctaRepository.getAll();
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	public Conta getContaSelecionada() {
		return contaSelecionada;
	}

	public void setContaSelecionada(Conta contaSelecionada) {
		this.contaSelecionada = contaSelecionada;
	}

	public void excluir(){
		ctaRepository.delete(contaSelecionada);
	}
	
	
}
