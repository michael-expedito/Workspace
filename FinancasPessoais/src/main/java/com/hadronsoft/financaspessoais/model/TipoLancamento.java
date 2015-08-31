package com.hadronsoft.financaspessoais.model;

public enum TipoLancamento {
	DEBITO("Débito"), CREDITO("Crédito"), TRANSFERENCIA("Transferência");

	private String descricao;

	TipoLancamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
