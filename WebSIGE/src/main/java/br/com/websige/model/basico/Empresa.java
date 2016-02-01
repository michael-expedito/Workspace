package br.com.websige.model.basico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRESA_EMP")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "EMP_ID")
	private Long id;

	@Column(name = "EMP_CDEMPRESA", nullable = false, length = 6)
	private String codigo;
	
	@Column(name = "EMP_NMEMPRESA", nullable = false, length = 40)
	private String nome;
	
	@Column(name = "EMP_CEP", nullable = true, length = 9)
	private String cep;
	
	@Column(name = "EMP_ENDERECO", nullable = true, length = 40)
	private String endereco;
	
	@Column(name = "EMP_NUMERO", nullable = true, length = 7)
	private String numero;
	
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
	
	@Column(name = "EMP_RAZAOSOCIAL", nullable = false, length = 80)
	private String razaoSocial;
	
	@Column(name = "EMP_CNPJ", nullable = false, length = 15)
	private String cnpj;
	
	@Column(name = "EMP_INSCRICAOESTADUAL", nullable = false, length = 18)
	private String inscricaoEstadual;
	
	@Column(name = "EMP_INSCRICAOMUNICIPAL", nullable = false, length = 18)
	private String inscricaoMunicipal;
	
	@Column(name = "EMP_CNAE", nullable = false, length = 15)
	private String cnae;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
