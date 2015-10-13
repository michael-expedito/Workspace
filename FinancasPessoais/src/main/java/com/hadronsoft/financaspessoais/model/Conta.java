package com.hadronsoft.financaspessoais.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CONTA_CTA")
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="CTA_ID")
	private Long  id;
	
	@NotNull
	@Column(name="CTA_DESCRICAO", nullable = false)
	private String nome;
	
	@NotNull
	@Column(name="CTA_TPCONTA", nullable = false)
	private TipoConta tipoConta;
	
	@NotNull
	@Column(name="CTA_VLSANDOINICIAL", nullable = false, precision = 10, scale = 2)
	private BigDecimal saldoInicial = BigDecimal.ZERO;
	
	@NotNull
	@Column(name="CTA_DTSALDOINICIAL", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataSaldoInicial = new Date();
	
	@Column(name="CTA_OBSERVACOES",columnDefinition = "TEXT" )
	private String observacoes;

	@Column(name="CTA_VLLIMITECREDITO", precision = 10, scale = 2)
	private BigDecimal valorLimiteCredito;
	
	@Column(name="CTA_DTCADASTRO", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataCadastro = new Date();
	
	@Column(name="CTA_INATIVA", nullable = false)
	private Boolean inativa = false;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="CTA_IDCADASTRO", nullable = false,  foreignKey = @ForeignKey(name="FK1_CONTA_CADASTRO"))
	private Cadastro cadastro;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public BigDecimal getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(BigDecimal saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public Date getDataSaldoInicial() {
		return dataSaldoInicial;
	}

	public void setDataSaldoInicial(Date dataSaldoInicial) {
		this.dataSaldoInicial = dataSaldoInicial;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public BigDecimal getValorLimiteCredito() {
		return valorLimiteCredito;
	}

	public void setValorLimiteCredito(BigDecimal valorLimiteCredito) {
		this.valorLimiteCredito = valorLimiteCredito;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getInativa() {
		return inativa;
	}

	public void setInativa(Boolean inativa) {
		this.inativa = inativa;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
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
		Conta other = (Conta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
