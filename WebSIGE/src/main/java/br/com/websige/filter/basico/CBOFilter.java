package br.com.websige.filter.basico;

import br.com.websige.model.basico.CBO;
import br.com.websige.pattern.GenericFilter;
import br.com.websige.pattern.annotations.FilterLabel;

public class CBOFilter extends GenericFilter<CBO> {
	
	@FilterLabel(label="Código ocupação")
	private String codigoOcupacao;
	
	@FilterLabel(label="Título ocupação")
	private String tituloOcupacao;

	public String getCodigoOcupacao() {
		return codigoOcupacao;
	}

	public void setCodigoOcupacao(String codigoOcupacao) {
		this.codigoOcupacao = codigoOcupacao;
	}

	public String getTituloOcupacao() {
		return tituloOcupacao;
	}

	public void setTituloOcupacao(String tituloOcupacao) {
		this.tituloOcupacao = tituloOcupacao;
	}
	
	
}
