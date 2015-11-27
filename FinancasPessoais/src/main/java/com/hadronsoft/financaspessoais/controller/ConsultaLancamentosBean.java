package com.hadronsoft.financaspessoais.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

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
import com.hadronsoft.financaspessoais.repository.filter.LancamentoFilter;
import com.hadronsoft.financaspessoais.service.CadastroLancamentos;
import com.hadronsoft.financaspessoais.service.NegocioException;
import com.hadronsoft.financaspessoais.service.ParcelamentoService;

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

	@Inject
	private ParcelamentoService parService;

	private Lancamento lancamentoSelecionado;
	private List<Lancamento> lancamentos;
	private List<Conta> contas;
	private LancamentoFilter filter;

	public ConsultaLancamentosBean() {

	}

	public void consultar() {

		if (filter == null) {
			filter = new LancamentoFilter();
		}

		if (filter.getPeriodoInicial() == null) {
			Calendar f = Calendar.getInstance(); // this takes current date
			f.set(Calendar.DAY_OF_MONTH, 1);
			filter.setPeriodoInicial(f.getTime());
		}
		if (filter.getPeriodoFinal() == null) {
			Calendar l = Calendar.getInstance(); // this takes current date
			l.set(Calendar.DAY_OF_MONTH, l.getActualMaximum(Calendar.DAY_OF_MONTH));
			filter.setPeriodoFinal(l.getTime());
		}

		this.lancamentos = lctRepository.getByFilter(filter);
		contas = ctaRepository.getAll();
	}

	public void excluir() {
		if (this.lancamentoSelecionado.getParcelamento() != null) {
			
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			try {
				if (this.lancamentoSelecionado.getParcelamento() == null) {
					this.cadastro.excluir(this.lancamentoSelecionado);
				} else {
					this.parService.excluir(lancamentoSelecionado.getParcelamento());
				}
				this.consultar();
				context.addMessage(null, new FacesMessage("Lançamento excluído com sucesso!"));
			} catch (NegocioException e) {
				FacesMessage mensagem = new FacesMessage(e.getMessage());
				mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
				context.addMessage(null, mensagem);
			}
		}
	}

	public BigDecimal getValorPorData(Lancamento obj) throws ParseException {
		Date data = obj.getDataVencimento();
		BigDecimal valorPorData = BigDecimal.ZERO;
		for (Lancamento lanc : lancamentos) {
			if (data.equals(lanc.getDataVencimento())) {
				BigDecimal valorLancamento = new BigDecimal(lanc.getValor().toString());
				if (lanc.getTipo() == TipoLancamento.CREDITO) {
					valorPorData = valorPorData.add(valorLancamento);
				} else {
					valorPorData = valorPorData.subtract(valorLancamento);
				}
			}
		}
		return valorPorData;
	}

	public String consultarLancamento(Lancamento lanc) {
		if (lanc.isDebito()) {
			return "/restrict/Lancamentos/CadastroDespesas?faces-redirect=true&lancamento=" + lanc.getId();
		} else {
			return "/restrict/Lancamentos/CadastroReceitas?faces-redirect=true&lancamento=" + lanc.getId();
		}
	}

	public void deletarLancamento(Lancamento lanc) {

		lctRepository.delete(lanc);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lançamento excluído com sucesso!"));
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

	public LancamentoFilter getFilter() {
		return filter;
	}

	public void setFilter(LancamentoFilter filter) {
		this.filter = filter;
	}

}
