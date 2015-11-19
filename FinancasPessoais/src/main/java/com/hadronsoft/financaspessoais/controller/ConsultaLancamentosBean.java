package com.hadronsoft.financaspessoais.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.hadronsoft.financaspessoais.model.Conta;
import com.hadronsoft.financaspessoais.model.Lancamento;
import com.hadronsoft.financaspessoais.model.TipoLancamento;
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

	public ConsultaLancamentosBean() {

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

	public BigDecimal getValorPorData(String dataVencimento) throws ParseException {	
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		java.sql.Date data = new java.sql.Date(format.parse(dataVencimento).getTime());
		BigDecimal valorPorData = BigDecimal.ZERO;
		for (Lancamento lanc : lancamentos) {
			if (data.equals(lanc.getDataVencimento())) {
				BigDecimal valorLancamento = new BigDecimal( lanc.getValor().toString() );
				if(lanc.getTipo() == TipoLancamento.CREDITO)
				{ 
					valorPorData = valorPorData.add(valorLancamento);
				} else {
					valorPorData = valorPorData.subtract(valorLancamento);
				}
			}
		}
		return valorPorData;
	}

	public int getRandomPrice() {
		return (int) (Math.random() * 100000);
	}

}
