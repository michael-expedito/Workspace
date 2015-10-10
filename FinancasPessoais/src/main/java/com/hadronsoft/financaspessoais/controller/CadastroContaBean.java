package com.hadronsoft.financaspessoais.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.hadronsoft.financaspessoais.model.Conta;
import com.hadronsoft.financaspessoais.model.Status;
import com.hadronsoft.financaspessoais.service.ContaService;
import com.hadronsoft.financaspessoais.service.NegocioException;

@Named
@SessionScoped
public class CadastroContaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ContaService ctaService;
	
	private Conta conta;

	public void prepararCadastro() {
		if (this.conta == null) {
			this.conta = new Conta();
		}
	}
	
	public void salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			ctaService.salvar(conta);
			this.conta = new Conta();
			context.addMessage(null, new FacesMessage("Lançamento salvo com sucesso!"));
			
		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);

			context.addMessage(null, mensagem);
		}
	}
	
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public Status[] getStatus() {
		return Status.values();
	}
	
}
