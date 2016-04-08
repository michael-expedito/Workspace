package br.com.websige.model.basico.endereco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.websige.pattern.interfaces.IBaseEntity;

@Entity
@Table(name="ESTADOUF_EUF")
public class UF implements IBaseEntity ,Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		UF other = (UF) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}
}
