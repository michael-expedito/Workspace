package com.hadronsoft.vendas.repositories.filters;

import java.io.Serializable;
import com.hadronsoft.vendas.validation.SKU;

public class ProdutoFilter implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public String sku;
	public String nome;
	
	@SKU
	public String getSku() {
		return sku;
	}
	
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
