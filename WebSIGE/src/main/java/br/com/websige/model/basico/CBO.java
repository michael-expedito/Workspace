package br.com.websige.model.basico;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.websige.pattern.interfaces.IBaseEntity;

@Entity
@Table(name="CLBROCUPACAO_CBO")
public class CBO implements IBaseEntity ,Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "CBO_ID")
	private Long id;
	
	@Column(name = "CBO_CDOCUPACAO", nullable = false, length = 6)
	private String codigoOcupacao;
	
	@Column(name = "CBO_TLOCUPACAO", nullable = false, length = 140)
	private String tituloOcupacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		CBO other = (CBO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
	
}
