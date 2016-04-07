package br.com.websige.filter.basico;

import br.com.websige.model.basico.Fornecedor;
import br.com.websige.pattern.FilterLabel;
import br.com.websige.pattern.GenericFilter;

public class FornecedorFilter extends GenericFilter<Fornecedor> {

	@FilterLabel(label="Código")
	private String codigo;
	
	@FilterLabel(label="Descrição")
	private String descricao;
	
	@FilterLabel(label="CNPJ")
	private String cnpj;
	
	@FilterLabel(label="Razão Social")
	private String razaoSocial;
	
	@FilterLabel(label="CPF")
	private String cpf;
	
	@FilterLabel(label="Nome")
	private String nomeFisico;
	
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
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNomeFisico() {
		return nomeFisico;
	}
	public void setNomeFisico(String nomeFisico) {
		this.nomeFisico = nomeFisico;
	}
	
	
}