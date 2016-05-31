package br.com.websige.model.basico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.websige.pattern.GenericEntity;

@Entity
@Table(name="SEGMENTO_SEG")
public class Segmento extends GenericEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "SEG_DSSEGMENTO", nullable = false, length = 100)
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
