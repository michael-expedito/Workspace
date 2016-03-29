package br.com.websige.filter.basico;

import br.com.websige.model.basico.Empresa;
import br.com.websige.pattern.FilterLabel;
import br.com.websige.pattern.GenericFilter;

public class EmpresaFilter extends GenericFilter<Empresa> {
	
	@FilterLabel(label="Código")
	private String codigo;
	
	@FilterLabel(label="CNPJ")
	private String CNPJ;
	
	@FilterLabel(label="Nome")
	private String nome;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
