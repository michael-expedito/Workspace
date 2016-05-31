package br.com.websige.model.basico.endereco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.websige.pattern.GenericEntity;
import br.com.websige.pattern.annotations.ResourceEntity;

@Entity
@Table(name="PAIS_PAS")
@ResourceEntity(resourceDirectory="basico.cadastro.pais.pais")
public class Pais extends GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "PAS_CDPAIS", nullable = false, length = 5)
	private String codigo;
	
	@Column(name = "PAS_NMPAIS", nullable = false, length = 48)
	private String nome;

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
}
