package com.hadronsoft.financaspessoais.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.hadronsoft.financaspessoais.model.Categoria;
import com.hadronsoft.financaspessoais.model.Conta;
import com.hadronsoft.financaspessoais.model.FrequenciaLancamento;
import com.hadronsoft.financaspessoais.model.Lancamento;
import com.hadronsoft.financaspessoais.model.Parcelamento;
import com.hadronsoft.financaspessoais.model.TipoLancamento;
import com.hadronsoft.financaspessoais.repository.CategoriaRepository;
import com.hadronsoft.financaspessoais.repository.ContaRepository;
import com.hadronsoft.financaspessoais.service.CadastroLancamentos;
import com.hadronsoft.financaspessoais.service.LancamentoService;
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
	@Inject
	private LancamentoService lancamentoService;

	private Lancamento lancamento = new Lancamento();
	private Parcelamento parcelamento = new Parcelamento();

	private List<Conta> todasContas;
	private List<Categoria> todasCategorias;

	private boolean pago;
	private boolean desconto;
	private boolean multa;
	private BigDecimal valorTotalParcelado;
	

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
		if (this.parcelamento == null) {
			this.parcelamento = new Parcelamento();
		}
	}

	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			// this.lancamento.setDataLancamento(new
			// Date(System.currentTimeMillis()));
			cadastro.salvar(this.lancamento);
			this.lancamento = new Lancamento();
			context.addMessage(null, new FacesMessage("Lançamento salvo com sucesso!"));

		} catch (NegocioException e) {

			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);

			context.addMessage(null, mensagem);
		}
	}

	public void salvarReceita() throws NegocioException {
		lancamento.setTipo(TipoLancamento.CREDITO);
		lancamentoService.salvar(lancamento, parcelamento);
	}
	
	public void salvarDespesa() throws NegocioException {
		lancamento.setTipo(TipoLancamento.DEBITO);
		lancamentoService.salvar(lancamento, parcelamento);
	}

	public void atualizaValorTotalParcelado() {
		if (parcelamento.getQuantidadeParcelas() != null && lancamento.getValor() != null) {
			BigDecimal qtdParcelas = new BigDecimal(parcelamento.getQuantidadeParcelas());
			valorTotalParcelado = (lancamento.getValor().multiply(qtdParcelas));
		} else {
			valorTotalParcelado = BigDecimal.ZERO;
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

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public Parcelamento getParcelamento() {
		return parcelamento;
	}

	public void setParcelamento(Parcelamento parcelamento) {
		this.parcelamento = parcelamento;
	}

	public FrequenciaLancamento[] getFrequenciaLancamento() {
		return FrequenciaLancamento.values();
	}

	public boolean isDesconto() {
		return desconto;
	}

	public void setDesconto(boolean desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getValorTotalParcelado() {
		return valorTotalParcelado;
	}

	public void setValorTotalParcelado(BigDecimal valorTotalParcelado) {
		this.valorTotalParcelado = valorTotalParcelado;
	}

	public boolean isMulta() {
		return multa;
	}

	public void setMulta(boolean multa) {
		this.multa = multa;
	}
	
	

}