package com.hadronsoft.financaspessoais.model;

import java.beans.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "LANCAMENTO_LCT")
public class Lancamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "LCT_ID")
	private Long id;

	@NotEmpty
	@Column(name = "LCT_DSLANCAMENTO", nullable = false)
	private String descricao;

	@NotNull
	@Column(name = "LCT_DTVENCIMENTO", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;

	@NotNull
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "LCT_TPLANCAMENTO", nullable = false)
	private TipoLancamento tipo;

	@NotNull
	@Column(name = "LCT_VLLANCAMENTO", nullable = false)
	private BigDecimal valor;

	@Column(name = "LCT_DTPAGAMENTO")
	@Temporal(TemporalType.DATE)
	private Date dataPagamento;

	@Column(name = "LCT_NRPARCELA")
	private Long numeroParcela;

	@Column(name = "LCT_VLDESCONTO", precision = 10, scale = 2)
	private BigDecimal valorDesconto;
	
	@Column(name ="LCT_DTDESCONTO")
	@Temporal(TemporalType.DATE)
	private Date dataDesconto;
	
	@Column(name="LCT_PEMULTA", precision = 3, scale = 2)
	private BigDecimal percentualMulta;
	
	@Column(name="LCT_MORADIARIA", precision = 3, scale = 2)
	private BigDecimal moraDiaria;

	@Column(name = "LCT_DSOBSERVACOES", columnDefinition = "TEXT")
	private String observacoes;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "LCT_IDCATEGORIA", nullable = false, foreignKey = @ForeignKey(name = "FK1_LANCAMENTO_CATEGORIA") )
	private Categoria categoria;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "LCT_IDCONTA", nullable = false, foreignKey = @ForeignKey(name = "FK2_LANCAMENTO_CONTA") )
	private Conta conta;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "LCT_IDCADASTRO", nullable = false, foreignKey = @ForeignKey(name = "FK3_LANCAMENTO_CADASTRO") )
	private Cadastro cadastro;
	
	@ManyToOne
	@JoinColumn(name="LCT_IDPARCELAMENTO", nullable = true, foreignKey = @ForeignKey(name="FK4_LANCAMENTO_PARCELAMENTO"))
	private Parcelamento parcelamento; 


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public TipoLancamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoLancamento tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Long getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(Long numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public Date getDataDesconto() {
		return dataDesconto;
	}

	public void setDataDesconto(Date dataDesconto) {
		this.dataDesconto = dataDesconto;
	}

	public BigDecimal getPercentualMulta() {
		return percentualMulta;
	}

	public void setPercentualMulta(BigDecimal percentualMulta) {
		this.percentualMulta = percentualMulta;
	}

	public BigDecimal getMoraDiaria() {
		return moraDiaria;
	}

	public void setMoraDiaria(BigDecimal moraDiaria) {
		this.moraDiaria = moraDiaria;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public Parcelamento getParcelamento() {
		return parcelamento;
	}

	public void setParcelamento(Parcelamento parcelamento) {
		this.parcelamento = parcelamento;
	}

	public void copyTo(Lancamento fullLancamento ){
		this.cadastro = (fullLancamento.getCadastro());
		this.categoria = (fullLancamento.getCategoria());
		this.conta = (fullLancamento.getConta());
		this.dataDesconto = (fullLancamento.getDataDesconto());
		this.dataPagamento = (fullLancamento.getDataPagamento());
		this.dataVencimento = (fullLancamento.getDataVencimento());
		this.descricao = (fullLancamento.getDescricao());
		this.id = (fullLancamento.getId());
		this.moraDiaria = (fullLancamento.getMoraDiaria());
		this.numeroParcela = (fullLancamento.getNumeroParcela());
		this.observacoes = (fullLancamento.getObservacoes());
		this.parcelamento = (fullLancamento.getParcelamento());
		this.percentualMulta = (fullLancamento.getPercentualMulta());
		this.tipo = (fullLancamento.getTipo());
		this.valor = (fullLancamento.getValor());
		this.valorDesconto = (fullLancamento.getValorDesconto());
		
	}
	
	@Transient
	public boolean isCredito(){
		return this.tipo == TipoLancamento.CREDITO;
	}
	
	@Transient
	public boolean isDebito(){
		return this.tipo == TipoLancamento.DEBITO;
	}
	
	@Transient
	public boolean isPago(){
		return this.dataPagamento != null;
	}
	
	@Transient
	public boolean isCartaoCredito(){
		return this.conta.getTipoConta() == TipoConta.CARTAOCREDITO;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
