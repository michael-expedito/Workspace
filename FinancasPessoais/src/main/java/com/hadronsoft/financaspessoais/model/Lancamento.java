package com.hadronsoft.financaspessoais.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@Column(name="LCT_ID")
	private Long id;
	
	@NotNull
	@Column(name="LCT_DTLANCAMENTO", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataLancamento;
	
	@Column(name="LCT_DTPAGAMENTO")
	@Temporal(TemporalType.DATE)
	private Date dataPagamento;
	
	@NotEmpty
	@Column(name="LCT_DSLANCAMENTO", nullable = false)
	private String descricao;
	
	@NotNull
	@Column(name="LCT_TPLANCAMENTO", nullable = false)
	private TipoLancamento tipo;
	
	@NotNull
	@Column(name="LCT_VLLANCAMENTO", nullable = false)
	private BigDecimal valor;
	
	@NotNull
	@Column(name="LCT_DTVENCIMENTO", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataVencimento;
	
	@Column(name="LCT_DSOBSERVACAO", columnDefinition = "TEXT")
	private String observacao;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="LCT_IDCATEGORIA", nullable = false,  foreignKey = @ForeignKey(name="FK1_LANCAMENTO_CATEGORIA"))
	private Categoria categoria;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="LCT_IDCONTA", nullable = false,  foreignKey = @ForeignKey(name="FK2_LANCAMENTO_CONTA"))
	private Conta conta;
	
	@OneToMany(mappedBy = "lancamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Parcela> parcelas;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
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
