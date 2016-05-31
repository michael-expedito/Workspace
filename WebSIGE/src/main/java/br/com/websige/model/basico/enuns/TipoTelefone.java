package br.com.websige.model.basico.enuns;

public enum TipoTelefone {
	CASA("Casa"), TRABALHO("Trabalho"), CELULAR("Celular"), FAX("Fax");
	
	private String descricao;
	
	TipoTelefone(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
