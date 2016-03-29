package br.com.websige.filter.basico;

import br.com.websige.model.basico.Empresa;
import br.com.websige.model.basico.Filial;
import br.com.websige.pattern.GenericFilter;

public class FilialFilter extends GenericFilter<Filial>{
	private Empresa empresa;

	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
