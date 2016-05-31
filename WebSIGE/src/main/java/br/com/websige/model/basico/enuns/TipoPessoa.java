package br.com.websige.model.basico.enuns;

public enum TipoPessoa {
	JURIDICA("Jurídica"), FISICA("Física");
	
	private String descricao;
	
	TipoPessoa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
