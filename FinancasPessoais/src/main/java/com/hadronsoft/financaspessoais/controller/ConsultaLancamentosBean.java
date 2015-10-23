package com.hadronsoft.financaspessoais.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.hadronsoft.financaspessoais.model.Conta;
import com.hadronsoft.financaspessoais.model.Lancamento;
import com.hadronsoft.financaspessoais.repository.ContaRepository;
import com.hadronsoft.financaspessoais.repository.LancamentoRepository;
import com.hadronsoft.financaspessoais.service.CadastroLancamentos;
import com.hadronsoft.financaspessoais.service.NegocioException;

@Named
@SessionScoped
public class ConsultaLancamentosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroLancamentos cadastro;
	
	@Inject
	LancamentoRepository lctRepository;

	@Inject 
	ContaRepository ctaRepository;
	
	private Lancamento lancamentoSelecionado;
	
	private List<Lancamento> lancamentos;
	
	private List<Conta> contas;

	public ConsultaLancamentosBean(){
		
	}
	
	public void consultar() {
		this.lancamentos = lctRepository.getAll();
		contas = ctaRepository.getAll();
	}

	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.cadastro.excluir(this.lancamentoSelecionado);
			this.consultar();
			context.addMessage(null, new FacesMessage("Lançamento excluído com sucesso!"));
		} catch (NegocioException e) {
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		}
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	public int getRandomPrice() {
        return (int) (Math.random() * 100000);
    }
	
}
