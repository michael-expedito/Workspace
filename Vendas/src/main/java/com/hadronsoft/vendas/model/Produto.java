package com.hadronsoft.vendas.model;

import java.beans.Transient;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.hadronsoft.vendas.services.NegocioException;
import com.hadronsoft.vendas.validation.SKU;

import javax.persistence.ForeignKey;

@Entity
@Table(name="PRODUTO_PRD")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	@Column(name="PRD_ID")
	private Long id;

	@NotBlank @Size(max = 80)
	@Column(name="PRD_NMPRODUTO", nullable = false, length = 80)
	private String nome;
	
	@NotBlank @Size(max = 20) @SKU
	@Column(name="PRD_CDSKU", nullable = false, length = 20, unique = true)
	private String sku;
	
	@NotNull
	@Column(name="PRD_VLUNITARIO", nullable = false, precision = 10, scale = 2)
	private BigDecimal valorUnitario;
	
	@NotNull @Min(0) @Max(9999)
	@Column(name="PRD_QTESTOQUE", nullable = false, length = 6)
	private Integer quantidadeEstoque;
	
	@NotNull          
	@ManyToOne
	@JoinColumn(name = "PRD_ID_CATEGORIA", nullable = false, foreignKey = @ForeignKey(name="FK1_PRODUTO_CATEGORIA"))
	private Categoria categoria;


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
		this.nome = nome.trim();
	}

	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku == null ? null : sku.toUpperCase();
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Transient 
	public void baixarEstoque(Integer quantidade) {
		int novaQuantidade = this.getQuantidadeEstoque() - quantidade;
		
		if (novaQuantidade < 0 ){ 
			throw new NegocioException("Não há quantidade no estoque de " 
					+ quantidade + " itens do produto "
					+ this.getSku() + ".");
		}
		this.setQuantidadeEstoque(novaQuantidade);
		
	}
	
	@Transient
	public void adicionarEstoque(Integer quantidade) {
		this.setQuantidadeEstoque(getQuantidadeEstoque() + quantidade);
		
	}

}