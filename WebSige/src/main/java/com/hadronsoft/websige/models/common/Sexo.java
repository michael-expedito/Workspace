package com.hadronsoft.websige.models.common;

public enum Sexo {
	MASCULINO("Masculino"),
	FEMININO("Feminino");
	
	
	private Sexo(String descricao) {
		this.descricao = descricao;
	}

	private String descricao;

	public String getDescricao() {
		return descricao;
	}
	
}
