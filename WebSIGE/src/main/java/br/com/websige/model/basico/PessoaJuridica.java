package br.com.websige.model.basico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.websige.pattern.GenericEntity;
import br.com.websige.pattern.annotations.ResourceEntity;

@Entity
@Table(name="PESJURIDICA_PJ")
@ResourceEntity(resourceDirectory="basico.cadastro.pessoajuridica.pessoajuridica")
public class PessoaJuridica extends GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "PJ_DCCNPJ", nullable = false, length = 14)
	private String cnpj;
	
	@Column(name = "PJ_NMRAZAOSOCIAL", nullable = false, length = 40)
	private String razaoSocial;
	
	@Column(name = "PJ_NMFANTASIA", nullable = true, length = 40)
	private String nomeFantasia;
	
	@Column(name = "PJ_NRINSCRICAOESTADUAL", nullable = true, length = 15)
	private String inscricaoEstadual;
	
	@Column(name = "PJ_NRINSCRICAOMUNICIPAL", nullable = true, length = 15)
	private String inscricaoMunicipal;
	
	@Column(name = "PJ_NRINSCRICAOSUFRAMA", nullable = true, length = 15)
	private String inscricaoSuframa;
	

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
}
