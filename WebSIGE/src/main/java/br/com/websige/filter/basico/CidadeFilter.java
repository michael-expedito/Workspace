package br.com.websige.filter.basico;

import java.io.Serializable;

import br.com.websige.model.basico.endereco.Cidade;
import br.com.websige.pattern.GenericFilter;
import br.com.websige.pattern.annotations.FilterLabel;

public class CidadeFilter extends GenericFilter<Cidade> implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@FilterLabel(label="Código")
	private String codigo;
	
	@FilterLabel(label="Cidade")
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
