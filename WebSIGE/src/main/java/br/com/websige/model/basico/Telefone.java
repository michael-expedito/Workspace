package br.com.websige.model.basico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.websige.model.basico.enuns.TipoTelefone;
import br.com.websige.pattern.GenericEntity;

@Entity
@Table(name="TELEFONE_TEL")
public class Telefone extends GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="TEL_CDPAIS", nullable = true, length = 3)
	private String codigoPais;
	
	@Column(name="TEL_CDDDD", nullable = true, length = 3)
	private String ddd;
	
	@Column(name="TEL_NRTELEFONE", nullable = false, length = 25)
	private String telefone;
	
	@Column(name = "TEL_TPTELEFONE", nullable = true)
	@Enumerated(EnumType.ORDINAL)
	private TipoTelefone tipoTelefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
}
