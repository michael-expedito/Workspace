package br.com.websige.filter.basico;

import br.com.websige.model.basico.endereco.Pais;
import br.com.websige.pattern.GenericFilter;
import br.com.websige.pattern.annotations.FilterLabel;

public class PaisFilter extends GenericFilter<Pais> {
	
	@FilterLabel(label="Código")
	private String codigo;
	
	@FilterLabel(label="Nome")
	private String nome;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
