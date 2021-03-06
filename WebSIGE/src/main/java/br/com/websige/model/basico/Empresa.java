package br.com.websige.model.basico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.websige.pattern.GenericEntity;
import br.com.websige.pattern.annotations.ResourceEntity;

@Entity
@Table(name = "EMPRESA_EMP")
@ResourceEntity(resourceDirectory="basico.cadastro.empresa.empresa")
public class Empresa extends GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "Código")
	@Column(name = "EMP_CDEMPRESA", nullable = false, length = 6)
	private String codigo;

	@NotNull(message = "Nome")
	@Column(name = "EMP_NMEMPRESA", nullable = false, length = 40)
	private String nome;

	@Column(name = "EMP_CEP", nullable = true, length = 9)
	private String cep;

	@Column(name = "EMP_ENDERECO", nullable = true, length = 40)
	private String endereco;

	@Column(name = "EMP_NUMERO", nullable = true, length = 7)
	private String numero;
	
	@Column(name = "EMP_COMPLEMENTO", nullable = true, length = 20)
	private String complemento;
	
	@Column(name = "EMP_BAIRRO", nullable = true, length = 30)
	private String bairro;

	@Column(name = "EMP_CIDADE", nullable = true, length = 30)
	private String cidade;

	@Column(name = "EMP_ESTADO", nullable = true, length = 2)
	private String estado;

	@Column(name = "EMP_TELEFONE", nullable = true, length = 20)
	private String telefone;

	@Column(name = "EMP_WEBSITE", nullable = true, length = 100)
	private String website;

	@NotNull
	@Column(name = "EMP_RAZAOSOCIAL", nullable = false, length = 80)
	private String razaoSocial;

	@NotNull(message = "CNPJ")
	@Column(name = "EMP_CNPJ", nullable = false, length = 15)
	private String cnpj;

	@NotNull(message = "Inscrição estadual")
	@Column(name = "EMP_INSCRICAOESTADUAL", nullable = false, length = 18)
	private String inscricaoEstadual;

	@NotNull(message = "Inscrição municipal")
	@Column(name = "EMP_INSCRICAOMUNICIPAL", nullable = false, length = 18)
	private String inscricaoMunicipal;

	@NotNull(message = "CNAE")
	@Column(name = "EMP_CNAE", nullable = false, length = 15)
	private String cnae;

	@Override @Column(name ="EMP_ID")
	public Long getId() {
		return super.id;
	}

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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getCnae() {
		return cnae;
	}

	public void setCnae(String cnae) {
		this.cnae = cnae;
	}
}
