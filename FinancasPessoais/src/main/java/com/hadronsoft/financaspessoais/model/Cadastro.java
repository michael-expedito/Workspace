package com.hadronsoft.financaspessoais.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CADASTRO_CAD")
public class Cadastro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "CAD_ID")
	private Long id;

	@NotNull
	@Column(name = "CAD_NOME", nullable = false, length = 40)
	private String nome;

	@NotNull
	@Column(name = "CAD_EMAIL", nullable = false, length = 255)
	private String email;

	@Column(name = "CAD_EMPRESA", nullable = true, length = 80)
	private String empresa;

	@NotNull
	@Column(name = "CAD_SENHA", nullable = false, length = 20)
	private String senha;

	@Column(name = "CAD_TELEFONE", nullable = true, length = 13)
	private String telefone;
	
	@Column(name = "CAD_DTCADASTRO", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
