package br.com.websige.model.crm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.websige.pattern.GenericEntity;

@Entity
@Table(name = "CATEGORIACLIENTE_CAC")
public class CategoriaCliente extends GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "CAC_DSCATEGORIACLIENTE", nullable = false, length = 40)
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
