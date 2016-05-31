package br.com.websige.model.basico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.websige.pattern.GenericEntity;
import br.com.websige.pattern.annotations.ResourceEntity;

@Entity
@Table(name="CLBROCUPACAO_CBO")
@ResourceEntity(resourceDirectory="basico.cadastro.cbo.cbo")
public class CBO extends GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "CBO_CDOCUPACAO", nullable = false, length = 6)
	private String codigoOcupacao;
	
	@Column(name = "CBO_TLOCUPACAO", nullable = false, length = 140)
	private String tituloOcupacao;

	public String getCodigoOcupacao() {
		return codigoOcupacao;
	}

	public void setCodigoOcupacao(String codigoOcupacao) {
		this.codigoOcupacao = codigoOcupacao;
	}

	public String getTituloOcupacao() {
		return tituloOcupacao;
	}

	public void setTituloOcupacao(String tituloOcupacao) {
		this.tituloOcupacao = tituloOcupacao;
	}

}
