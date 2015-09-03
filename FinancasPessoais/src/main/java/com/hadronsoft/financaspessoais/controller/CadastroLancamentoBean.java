package com.hadronsoft.financaspessoais.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.hadronsoft.financaspessoais.model.Categoria;
import com.hadronsoft.financaspessoais.model.Conta;
import com.hadronsoft.financaspessoais.model.Lancamento;
import com.hadronsoft.financaspessoais.model.TipoLancamento;
import com.hadronsoft.financaspessoais.repository.CategoriaRepository;
import com.hadronsoft.financaspessoais.repository.ContaRepository;
import com.hadronsoft.financaspessoais.service.CadastroLancamentos;
import com.hadronsoft.financaspessoais.service.NegocioException;

@Named
@ViewScoped
public class CadastroLancamentoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroLancamentos cadastro;

	@Inject
	private CategoriaRepository catRepository;

	@Inject
	private ContaRepository ctaRepository;

	private Lancamento lancamento = new Lancamento();

	private List<Conta> todasContas;

	private List<Categoria> todasCategorias;

	public void dataVencimentoAlterada(AjaxBehaviorEvent event) {
		if (this.lancamento.getDataPagamento() == null) {
			this.lancamento.setDataPagamento(this.lancamento.getDataVencimento());
		}
	}

	public void prepararCadastro() {
		this.todasContas = ctaRepository.getAll();
		this.todasCategorias = catRepository.getAll();
		if (this.lancamento == null) {
			this.lancamento = new Lancamento();
		}
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.lancamento.setDataLancamento(new Date(System.currentTimeMillis()));
			cadastro.salvar(this.lancamento);
			this.lancamento = new Lancamento();
			context.addMessage(null, new FacesMessage("Lançamento salvo com sucesso!"));

		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);

			context.addMessage(null, mensagem);
		}
	}

	public List<Categoria> getTodasCategorias() {
		return todasCategorias;
	}

	public List<Conta> getTodasContas() {
		return this.todasContas;
	}

	public TipoLancamento[] getTiposLancamentos() {
		return TipoLancamento.values();
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}
}