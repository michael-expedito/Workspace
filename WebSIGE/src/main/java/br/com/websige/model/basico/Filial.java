package br.com.websige.model.basico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.websige.pattern.interfaces.IBaseEntity;

@Entity
@Table(name="FILIAL_FIL")
public class Filial implements IBaseEntity ,Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="FIL_ID")
	private long id;
	
	@Column(name = "FIL_CDFILIAL", nullable = false, length = 6)
	private String codigo;
	
	@Column(name = "FIL_DSFILIAL", nullable = false, length = 40)
	private String descricao;
	
	@Column(name = "FIL_CEP", nullable = true, length = 9)
	private String cep;
	
	@Column(name = "FIL_ENDERECO", nullable = true, length = 40)
	private String endereco;
	
	@Column(name = "FIL_NUMERO", nullable = true, length = 7)
	private String numero;
	
	@Column(name = "FIL_COMPLEMENTO", nullable = true, length = 20)
	private String complemento;
	
	@Column(name = "FIL_BAIRRO", nullable = true, length = 30)
	private String bairro;
	
	@Column(name = "FIL_CIDADE", nullable = true, length = 30)
	private String cidade;
	
	@Column(name = "FIL_ESTADO", nullable = true, length = 2)
	private String estado;
	
	@Column(name = "FIL_TELEFONE", nullable = true, length = 20)
	private String telefone;
	
	@Column(name = "FIL_RAZAOSOCIAL", nullable = false, length = 80)
	private String razaoSocial;
	
	@Column(name = "FIL_CNPJ", nullable = false, length = 15)
	private String cnpj;
	
	@Column(name = "FIL_INSCRICAOESTADUAL", nullable = true, length = 18)
	private String inscricaoEstadual;
	
	@Column(name = "FIL_INSCRICAOMUNICIPAL", nullable = true, length = 18)
	private String inscricaoMunicipal;
	
	@Column(name = "FIL_CNAE", nullable = false, length = 15)
	private String cnae;
	
	@ManyToOne
	@JoinColumn(name = "FIL_IDEMPRESA", nullable = false, foreignKey = @ForeignKey(name = "FK1_FILIAL"))
	private Empresa empresa;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
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

	
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Filial other = (Filial) obj;
		if (id != other.id)
			return false;
		return true;
	}


	
	
}
