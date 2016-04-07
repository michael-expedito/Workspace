package br.com.websige.model.basico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.websige.pattern.interfaces.IBaseEntity;

@Entity
@Table(name="PESJURIDICA_PJ")
public class PessoaJuridica implements IBaseEntity ,Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "PJ_ID")
	private Long id;
	
	@Column(name = "PJ_DCCNPJ", nullable = true, length = 14)
	private String cnpj;
	
	@Column(name = "PJ_NMRAZAOSOCIAL", nullable = true, length = 40)
	private String razaoSocial;
	
	@Column(name = "PJ_NMFANTASIA", nullable = true, length = 40)
	private String nomeFantasia;
	
	@Column(name = "PJ_NRINSCRICAOESTADUAL", nullable = true, length = 15)
	private String inscricaoEstadual;
	
	@Column(name = "PJ_NRINSCRICAOMUNICIPAL", nullable = true, length = 15)
	private String inscricaoMunicipal;
	
	@Column(name = "PJ_NRINSCRICAOSUFRAMA", nullable = true, length = 15)
	private String inscricaoSuframa;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
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

	public String getInscricaoSuframa() {
		return inscricaoSuframa;
	}

	public void setInscricaoSuframa(String inscricaoSuframa) {
		this.inscricaoSuframa = inscricaoSuframa;
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
		PessoaJuridica other = (PessoaJuridica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
