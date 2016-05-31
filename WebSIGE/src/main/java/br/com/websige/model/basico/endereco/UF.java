package br.com.websige.model.basico.endereco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.websige.pattern.GenericEntity;
import br.com.websige.pattern.annotations.ResourceEntity;

@Entity
@Table(name="ESTADOUF_EUF")
@ResourceEntity(resourceDirectory="basico.cadastro.uf.uf")
public class UF extends GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "EUF_CDESTADO", nullable = false, length = 2)
	private String codigo;
	
	@Column(name = "EUF_DSESTADO", nullable = false, length = 20)
	private String descricao;
	
	@Column(name = "EUF_SGESTADO", nullable = false, length = 2)
	private String sigla;

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
