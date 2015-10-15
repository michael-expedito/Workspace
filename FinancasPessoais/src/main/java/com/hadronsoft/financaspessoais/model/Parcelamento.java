package com.hadronsoft.financaspessoais.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;

@Entity
@Table(name="PARCELAMENTO_PAR")
public class Parcelamento implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="PAR_ID")
	private Long id;
	
	@Column(name="PAR_QTPARCELAS", nullable = false)
	private Long quantidadeParcelas = (long) 0;
	
	@Column(name="PAR_FREQUENCIA", nullable = false)
	private FrequenciaLancamento frequenciaLancamento;
	
	@OneToMany(mappedBy="parcelamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Lancamento> lancamentos;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="PAR_IDCADASTRO", nullable = false, foreignKey = @ForeignKey(name="FK1_PARCELAMENTO_CADASTRO"))
	private Cadastro cadastro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantidadeParcelas() {
		return quantidadeParcelas;
	}

	public void setQuantidadeParcelas(Long quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}

	public FrequenciaLancamento getFrequenciaLancamento() {
		return frequenciaLancamento;
	}

	public void setFrequenciaLancamento(FrequenciaLancamento frequenciaLancamento) {
		this.frequenciaLancamento = frequenciaLancamento;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
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
		Parcelamento other = (Parcelamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
