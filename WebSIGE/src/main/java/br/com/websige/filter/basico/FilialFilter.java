package br.com.websige.filter.basico;

import br.com.websige.model.basico.Empresa;
import br.com.websige.model.basico.Filial;
import br.com.websige.pattern.GenericFilter;

public class FilialFilter extends GenericFilter<Filial>{
	private Empresa empresa;
	private String codigo;
	private String descricao;
	private String cnpj;

	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
